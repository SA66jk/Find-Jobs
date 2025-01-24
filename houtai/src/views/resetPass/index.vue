<template>
	<div>
			<el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
				<el-form-item label="Formerly Password" prop="password">
					<el-input size="small" v-model="editForm.password" show-password auto-complete="off" placeholder="Please enter the original password"></el-input>
				</el-form-item>
				<el-form-item label="New Password" prop="newPassword">
					<el-input size="small" v-model="editForm.newPassword" show-password auto-complete="off" placeholder="Please enter a new password"></el-input>
				</el-form-item>
				<el-form-item label="The new password is duplicated" prop="newPassword2">
					<el-input size="small" v-model="editForm.newPassword2" show-password auto-complete="off" placeholder="Please repeat the new password"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">revise</el-button>
			</div>
	</div>
</template>

<script>
	import Pagination from "@/layout/pagination/Pagination";
	import {Session} from "@/utils/storage";
	import {qiyexinxiUpdatePassword} from "@/api/qiyexinxi/qiyexinxiApi";
	import {yonghuxinxiUpdatePassword} from "@/api/yonghuxinxi/yonghuxinxiApi";
	
	import {guanliyuanUpdatePassword} from "@/api/guanliyuan/guanliyuanApi";
	export default {
		name: 'user',
		data() {
			return {
				loading: false, //是显示加载
				title: '',
				editFormVisible: false, //控制Edit页面显示与隐藏
				editForm: {
				},
				user:[],
				// rules表单验证
				rules: {
					password: [
						{ required: true, message: 'Please enter the account number原Password', trigger: 'blur' }
					],
					newPassword: [
						{ required: true, message: 'Please enter the account number新Password', trigger: 'blur' }
					],
					newPassword2: [
						{ required: true, message: 'Please enter the account number新Password', trigger: 'blur' }
					],
				},
				// 请求数据参数
				formInline: {
					page: 1,
					limit: 10,
				},
				listData: [],

				// 选中
				checkmenu: [],
				// 分页参数
				pageparm: {
					currentPage: 1,
					pageSize: 10,
					total: 0
				}
			};
		},
		methods: {
			// Edit、增加页面Save方法
			submitForm: function (editData) {
				this.$refs[editData].validate(valid => {
					if (valid) {
						if (this.editForm.newPassword === this.editForm.newPassword2) {
							this.userInfo = Session.get('userInfo');
							this.editForm.id = this.userInfo.id;
							if (this.userInfo.roles[0] == 'guanliyuan') {
								guanliyuanUpdatePassword(this.editForm).then(res => {
									if (res.code == "0") {
										this.$message.success('修改成功，为了安全，系统将自动清空session，请您重新登陆')
										setTimeout(() => {
											Session.clear();
											// 使用 reload 时，不需要调用 resetRoute() 重置路由
											window.location.reload();
										}, 2000);
									}
								}).catch(err => {
									this.loading = false
									this.$message.error(err)
								})

							}
							else if (this.userInfo.roles[0] == 'qiye') {
								qiyexinxiUpdatePassword(this.editForm).then(res => {
									if (res.code == "0") {
										this.$message.success('修改成功，为了安全，系统将自动清空session，请您重新登陆')
										setTimeout(() => {
											Session.clear();
											window.location.reload();
										}, 2000);
									}
								}).catch(err => {
									this.loading = false
									this.$message.error(err)
								})
							}
else if (this.userInfo.roles[0] == 'yonghu') {
								yonghuxinxiUpdatePassword(this.editForm).then(res => {
									if (res.code == "0") {
										this.$message.success('修改成功，为了安全，系统将自动清空session，请您重新登陆')
										setTimeout(() => {
											Session.clear();
											window.location.reload();
										}, 2000);
									}
								}).catch(err => {
									this.loading = false
									this.$message.error(err)
								})
							}

							
						}
						else {
							this.$message({
								type: 'error',
								message: 'The password is inconsistent twice'
							})
						}
					} else {
						return false
					}
				})
			},
		}
	};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
