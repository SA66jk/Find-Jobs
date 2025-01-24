<template>
	<div class="personal">
		<el-form label-width="100px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="Job Title" prop="gangweimingcheng"><el-input size="small" v-model="editForm.gangweimingcheng" auto-complete="off" placeholder="Please enter a Job Title" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="working hours" prop="gongzuoshijian"><el-input size="small" v-model="editForm.gongzuoshijian" auto-complete="off" placeholder="Please enter your working hours" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="Enterprise number" prop="qiyehao"><el-input size="small" v-model="editForm.qiyehao" auto-complete="off" placeholder="请Enter your enterprise number" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="The name of the business" prop="qiyemingcheng"><el-input size="small" v-model="editForm.qiyemingcheng" auto-complete="off" placeholder="Please enter the account numberThe name of the business" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="Head" prop="fuzeren"><el-input size="small" v-model="editForm.fuzeren" auto-complete="off" placeholder="Please enter the person in charge" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="Username" prop="yonghuming"><el-input size="small" v-model="editForm.yonghuming" auto-complete="off" placeholder="Please enter a username" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="name" prop="xingming"><el-input size="small" v-model="editForm.xingming" auto-complete="off" placeholder="Please enter a name" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="phone" prop="shouji"><el-input size="small" v-model="editForm.shouji" auto-complete="off" placeholder="Please enter your mobile phone" style='width:50%'></el-input></el-form-item>
		<el-form-item  label='Curriculum vitae documents' prop='jianliwenjian'><el-upload class='avatar-uploader' action='http://localhost:9999/files/uploadwenjian' :headers='headers' :show-file-list='false' :on-success='handleJianliwenjianSuccess' ><el-button>upload</el-button></el-upload></el-form-item>
		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">Add</el-button>
		</div>
	</div>
</template>

<script>
	import {jianlitoudiEdit, jianlitoudiSave,jianlitoudiDetail} from "@/api/jianlitoudi/jianlitoudiApi";
	import {Session} from "@/utils/storage";
import {gangweixinxiDetail,gangweixinxiEdit} from "../../api/gangweixinxi/gangweixinxiApi";
//xiabiaoduan1
export default {
	name: 'personal',
	data() {
		return {
			rules: {
				//yztssssss1
			},
			editForm: {
				avater:'',
				gangweimingcheng:'',
				gongzuoshijian:'',
				qiyehao:'',
				qiyemingcheng:'',
				fuzeren:'',
				
			},
			username:'',
			cx:'',
			//xiabiaoduan2
		};
	},
	created() {
		if (!Session.get('userInfo')) return false;
		this.userInfo = Session.get('userInfo');
		this.username=localStorage.getItem("username");
		this.cx=localStorage.getItem("cx");
		let id = this.$route.params.id;
		//xiabiaoduan3
		this.getUserInfo(id);
	},
	computed: {
		headers(){
			return {"token":Session.get("token")}
		},
	},
	methods:{
		getUserInfo(id){
			gangweixinxiDetail(id).then(res=>{
				if(res.code == '0'){
					this.gangweixinxi = res.data
					this.editForm.gangweimingcheng = this.gangweixinxi.gangweimingcheng;
					this.editForm.gongzuoshijian = this.gangweixinxi.gongzuoshijian;
					this.editForm.qiyehao = this.gangweixinxi.qiyehao;
					this.editForm.qiyemingcheng = this.gangweixinxi.qiyemingcheng;
					this.editForm.fuzeren = this.gangweixinxi.fuzeren;
				
					this.editForm.yonghuming= this.userInfo.yonghuming;
					
					this.editForm.xingming= this.userInfo.xingming;
				this.editForm.shouji= this.userInfo.shouji;
				
				}
			})
		},
		
		//qixuzhijixsuan3
		//xia2sui1
		// Edit、增加页面Save方法
		submitForm(editData) {
			
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						
					}else {
						jianlitoudiSave(this.editForm).then(res => {
							if (res.code == '0') {
								
								this.$message({
									type: 'success',
									message: 'Add success！'
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
		
		handleJianliwenjianSuccess(res, file) {
				if(res.code == "0") {
					this.editForm.jianliwenjian = "/files/download/"+res.data.id
					this.$message({
						type: 'success',
						message: 'The file was uploaded successfully！'
					})
				}
				else {
					this.$message({
						type: 'info',
						message: res.msg
					})
				}
			},
			download(data){
			location.href = data.jianliwenjian;
		},
				//youscwexnjiaxn
		//xiabiaoduan4
	}
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
