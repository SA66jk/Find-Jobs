<template>
	<div class="personal">
		<el-form label-width="100px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="Job Title" prop="gangweimingcheng"><el-input size="small" v-model="editForm.gangweimingcheng" auto-complete="off" placeholder="Please enter a Job Title" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="Username" prop="yonghuming"><el-input size="small" v-model="editForm.yonghuming" auto-complete="off" placeholder="Please enter a username" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="name" prop="xingming"><el-input size="small" v-model="editForm.xingming" auto-complete="off" placeholder="Please enter a name" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="Title" prop="biaoti"><el-input size="small" v-model="editForm.biaoti" auto-complete="off" placeholder="Please enter a title" style='width:100%'></el-input></el-form-item>
		<el-form-item  label="content" prop="neirong"><el-input type="textarea" size="small" v-model="editForm.neirong" auto-complete="off" placeholder="Please enter your content" style='width:100%'></el-input></el-form-item>
		<el-form-item  label="Notification time" prop="tongzhishijian"><el-date-picker type="datetime" value-format="yyyy-MM-dd hh:mm:ss" size="small" v-model="editForm.tongzhishijian" style='width:50%'/></el-form-item>
		<el-form-item  label="Enterprise number" prop="qiyehao"><el-input size="small" v-model="editForm.qiyehao" auto-complete="off" placeholder="请Enter your enterprise number" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="Head" prop="fuzeren"><el-input size="small" v-model="editForm.fuzeren" auto-complete="off" placeholder="Please enter the person in charge" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="Contact number" prop="lianxidianhua"><el-input size="small" v-model="editForm.lianxidianhua" auto-complete="off" placeholder="Please enter your contact number" style='width:50%'></el-input></el-form-item>
		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">Add</el-button>
		</div>
	</div>
</template>

<script>
	import {xiaoxitongzhiEdit, xiaoxitongzhiSave,xiaoxitongzhiDetail} from "@/api/xiaoxitongzhi/xiaoxitongzhiApi";
	import {Session} from "@/utils/storage";
import {jianlitoudiDetail,jianlitoudiEdit} from "../../api/jianlitoudi/jianlitoudiApi";
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
				yonghuming:'',
				xingming:'',
				
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
			jianlitoudiDetail(id).then(res=>{
				if(res.code == '0'){
					this.jianlitoudi = res.data
					this.editForm.gangweimingcheng = this.jianlitoudi.gangweimingcheng;
					this.editForm.yonghuming = this.jianlitoudi.yonghuming;
					this.editForm.xingming = this.jianlitoudi.xingming;
				
					this.editForm.qiyehao= this.userInfo.qiyehao;
					
					this.editForm.fuzeren= this.userInfo.fuzeren;
				this.editForm.lianxidianhua= this.userInfo.lianxidianhua;
				
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
						xiaoxitongzhiSave(this.editForm).then(res => {
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
		
		//youscwexnjiaxn
		//xiabiaoduan4
	}
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
