<template>
	<div class="personal">
		<el-form label-width="80px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="Enterprise number" prop="qiyehao"><el-input size="small" v-model="editForm.qiyehao" auto-complete="off" placeholder="请Enter your enterprise number" style='width:25%'></el-input></el-form-item>
		
		<el-form-item  label="The name of the business" prop="qiyemingcheng"><el-input size="small" v-model="editForm.qiyemingcheng" auto-complete="off" placeholder="Please enter the account numberThe name of the business" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="Business address" prop="qiyedizhi"><el-input size="small" v-model="editForm.qiyedizhi" auto-complete="off" placeholder="Please enter your business address" style='width:50%'></el-input></el-form-item>
		<el-form-item  label='Corporate photos' prop='qiyezhaopian'><el-upload class='avatar-uploader' action='http://localhost:9999/files/upload' :headers='headers' :show-file-list='false' :on-success='handleQiyezhaopianSuccess' :before-upload='beforeQiyezhaopianUpload'><img v-if='editForm.qiyezhaopian' :src='editForm.qiyezhaopian' class='avatar'><i v-else class='el-icon-plus avatar-uploader-icon'></i></el-upload></el-form-item>
		<el-form-item  label="Head" prop="fuzeren"><el-input size="small" v-model="editForm.fuzeren" auto-complete="off" placeholder="Please enter the person in charge" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="Contact number" prop="lianxidianhua"><el-input size="small" v-model="editForm.lianxidianhua" auto-complete="off" placeholder="Please enter your contact number" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="Company Profile" prop="qiyejianjie"><el-input type="textarea" size="small" v-model="editForm.qiyejianjie" auto-complete="off" placeholder="Please enter a company profile" style='width:50%'></el-input></el-form-item>
		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">update</el-button>
		</div>
	</div>
</template>

<script>
	import {qiyexinxiEdit, qiyexinxiSave,qiyexinxiDetail} from "@/api/qiyexinxi/qiyexinxiApi";
	import {Session} from "@/utils/storage";

export default {
	name: 'personal',
	data() {
		return {
			rules: {
				qiyehao: [{ required: true, message: '请Enter your enterprise number', trigger: 'blur' },
				],
				lianxidianhua: [{ pattern: /^[1][3,4,5,7,8][0-9]{9}$/,required: true,message: 'Please enter a valid mobile phone number',trigger: 'blur'}
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
			qiyexinxiDetail(this.userInfo.id).then(res=>{
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
						qiyexinxiEdit(this.editForm).then(res => {
							if (res.code == '0') {
								this.getDetail()
								this.$message({
									type: 'success',
									message: 'The personal information has been modified successfully！'
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
						qiyexinxiSave(this.editForm).then(res => {
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
		handleQiyezhaopianSuccess(res, file) {
				if(res.code == "0") {
					this.editForm.qiyezhaopian = "/files/download/"+res.data.id
				}
			},
			beforeQiyezhaopianUpload(file) {
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
