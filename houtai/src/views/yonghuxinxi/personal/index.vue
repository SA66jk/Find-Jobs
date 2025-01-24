<template>
	<div class="personal">
		<el-form label-width="80px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="Username" prop="yonghuming"><el-input size="small" v-model="editForm.yonghuming" auto-complete="off" placeholder="Please enter a username" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="name" prop="xingming"><el-input size="small" v-model="editForm.xingming" auto-complete="off" placeholder="Please enter a name" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="gender" prop="xingbie"><el-radio v-model="editForm.xingbie" :label=true>man</el-radio><el-radio v-model="editForm.xingbie" :label=false>woman</el-radio></el-form-item>
		
		<el-form-item  label="phone" prop="shouji"><el-input size="small" v-model="editForm.shouji" auto-complete="off" placeholder="Please enter your mobile phone" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="identity card" prop="shenfenzheng"><el-input size="small" v-model="editForm.shenfenzheng" auto-complete="off" placeholder="Please enter your ID" style='width:25%'></el-input></el-form-item>
		<el-form-item  label='avatar' prop='touxiang'><el-upload class='avatar-uploader' action='http://localhost:9999/files/upload' :headers='headers' :show-file-list='false' :on-success='handleTouxiangSuccess' :before-upload='beforeTouxiangUpload'><img v-if='editForm.touxiang' :src='editForm.touxiang' class='avatar'><i v-else class='el-icon-plus avatar-uploader-icon'></i></el-upload></el-form-item>
		<el-form-item  label="comment" prop="beizhu"><el-input size="small" v-model="editForm.beizhu" auto-complete="off" placeholder="Please enter a comment" style='width:25%'></el-input></el-form-item>
		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">update</el-button>
		</div>
	</div>
</template>

<script>
	import {yonghuxinxiEdit, yonghuxinxiSave,yonghuxinxiDetail} from "@/api/yonghuxinxi/yonghuxinxiApi";
	import {Session} from "@/utils/storage";

export default {
	name: 'personal',
	data() {
		return {
			rules: {
				yonghuming: [{ required: true, message: 'Please enter a username', trigger: 'blur' },
				],
				xingming: [{ required: true, message: 'Please enter a name', trigger: 'blur' },
				],
				shenfenzheng: [{ pattern:/^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/,required: true,message: 'Please enter the correct ID number',trigger: 'blur'}
				],
				
			},
			editForm: {
				avater:''
			},
		};
	},
	created() {
		this.getDetail()
	},
	computed: {
		headers(){
			return {"token":Session.get("token")}
		},
	},
	methods:{
		getDetail(){
			if (!Session.get('userInfo')) return false;
			this.userInfo = Session.get('userInfo');
			console.log(this.userInfo);
			yonghuxinxiDetail(this.userInfo.id).then(res=>{
				if (res.code == '0') {
					this.editForm = res.data;
				}
			}).catch(err => {
				if(err){
					this.$message.error(err)
				}else {
					this.$message.error('Operate失败，请稍后再试！')
				}
			})
		},
		
		// Edit、增加页面Save方法
		submitForm(editData) {
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						yonghuxinxiEdit(this.editForm).then(res => {
							if (res.code == '0') {
								this.getDetail()
								this.$message({
									type: 'success',
									message: '个人信息修改成功！'
								})
								this.$store.dispatch('userInfos/setUserInfos',this.editForm);
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							if(err){
								this.$message.error(err)
							}else {
								this.$message.error('Operate失败，请稍后再试！')
							}
						})
					}else {
						yonghuxinxiSave(this.editForm).then(res => {
							if (res.code == '0') {
								this.getDetail()
								this.$message({
									type: 'success',
									message: 'The personal information was added successfully！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							if(err){
								this.$message.error(err)
							}else {
								this.$message.error('Operate失败，请稍后再试！')
							}
						})
					}
				} else {
					return false
				}
			})
		},
		handleTouxiangSuccess(res, file) {
				if(res.code == "0") {
					this.editForm.touxiang = "/files/download/"+res.data.id
				}
			},
			beforeTouxiangUpload(file) {
				const isJPG = file.type === 'image/jpeg';
				const isLt2M = file.size / 1024 / 1024 < 2;

				if (!isJPG) {
					this.$message.error('Uploaded images can only be in JPG format!');
				}
				if (!isLt2M) {
					this.$message.error('The size of the uploaded image cannot exceed 2MB!');
				}
				return isJPG && isLt2M;
			},
				
	}
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
