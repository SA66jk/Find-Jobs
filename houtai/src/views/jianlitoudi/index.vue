<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search">
			<el-form-item label=""><el-input size="small" v-model="formInline.gangweimingcheng" placeholder="Enter the Job Title"></el-input></el-form-item>
			<el-form-item label=""><el-input size="small" v-model="formInline.gongzuoshijian" placeholder="Enter working hours"></el-input></el-form-item>

			<el-form-item>
				<el-button size="small" type="warning" icon="el-icon-search" @click="search">Search</el-button>

				<el-button size="small" type="success" icon="el-icon-s-data" @click="daochu()" v-if="userInfo.roles[0] == 'guanliyuan'">Export</el-button>
				<el-button size="small" type="danger" icon="el-icon-delete" @click="handleDeleteList()" v-if="userInfo.roles[0] == 'guanliyuan'">Delete in bulk</el-button>

			</el-form-item>
			<el-form-item>
				<el-upload class="upload-demo" style="float: left; padding-right: 10px;" action='http://localhost:9999/jianlitoudi/upload' :headers='headers' :show-file-list='false' :on-success='handleDaoruSuccess' :before-upload='beforeDaoruUpload' ><el-button size="small" type="info" icon="el-icon-sell" v-if="userInfo.roles[0] == 'guanliyuan'">Import</el-button></el-upload>
			</el-form-item>
		</el-form>

		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="Loading..." @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
			<el-table-column sortable prop="gangweimingcheng" label="Job Title"></el-table-column>
			<el-table-column sortable prop="gongzuoshijian" label="working hours"></el-table-column>
			<el-table-column sortable prop="qiyehao" label="Enterprise number"></el-table-column>
			<el-table-column sortable prop="qiyemingcheng" label="The name of the business"></el-table-column>
			<el-table-column sortable prop="fuzeren" label="Head"></el-table-column>
			<el-table-column sortable prop="yonghuming" label="Username"></el-table-column>
			<el-table-column sortable prop="xingming" label="name"></el-table-column>
			<el-table-column sortable prop="shouji" label="phone"></el-table-column>
			<el-table-column align='center' sortable prop='jianliwenjian' label='Curriculum vitae documents' width='120'><template slot-scope='scope'><el-button @click="download(scope.row)">Download</el-button></template></el-table-column>
			<el-table-column sortable prop="issh" label="Whether or not to audit"></el-table-column>
			<el-table-column sortable prop="shhf" label="Review responses"></el-table-column>

			<el-table-column sortable prop="addtime" label="Add Time" width="160">
				<template slot-scope="scope">
					<div>{{scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss')}}</div>
				</template>
			</el-table-column>

			<el-table-column align="center" label="Operate" min-width="160">
				<template slot-scope="scope">
					<el-button size='mini' type='primary' @click='hsgshenhe(scope.$index, scope.row)' v-if="userInfo.roles[0] == 'guanliyuan'|| userInfo.roles[0] == 'qiye' ">Audit</el-button>
					<!--liangbuan-->
					<el-button size="mini" type="success" @click="handleEdit(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == 'qiye' || userInfo.roles[0] == 'yonghu'">Edit</el-button>
					<el-button size="mini" type="danger" @click="deleteJianlitoudi(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == 'qiye' || userInfo.roles[0] == 'yonghu'">Delete</el-button>
					<el-button size='mini' type='primary' @click="handleDetail(scope.$index, scope.row)">Detailed</el-button>
					<!--zhixfuanniu-->

				</template>
			</el-table-column>
		</el-table>
		<Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>

		<el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
			<el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
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
				<el-button size="small" @click="closeDialog">Cancel</el-button>
				<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">Save</el-button>
			</div>
		</el-dialog>
			<el-dialog :title="titleissh" :visible.sync="isshdialog" width="30%" @click="closeisshdialog">
			<el-form label-width="120px" :model="editForm" :rules="rulesissh" ref="editFormissh">
				<el-form-item label="Review status" prop="shenqingStatus">
					<el-radio v-model="editForm.issh" label="To be reviewed">To be reviewed</el-radio>
					<el-radio v-model="editForm.issh" label="Passed">Passed</el-radio>
					<el-radio v-model="editForm.issh" label="Failed">Failed</el-radio>
				</el-form-item>
				<el-form-item label="Review responses" prop="shhf"><el-input type="textarea" size="small" v-model="editForm.shhf" auto-complete="off" placeholder="Please enter a review response"></el-input></el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button size="small" @click="closeisshdialog">Cancel</el-button>
				<el-button size="small" type="primary" :loading="loading" class="title" @click="shenhe('editFormissh')">Save</el-button>
			</div>
		</el-dialog>

			<!--xiangxidhk-->
			<!--zhixfudhk-->
	</div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import { jianlitoudiList, jianlitoudiSave, jianlitoudiDelete,jianlitoudiEdit,jianlitoudiDeleteList } from '@/api/jianlitoudi/jianlitoudiApi';


import {Session} from "@/utils/storage";
import axios from 'axios';
export default {
	name: 'user',
	data() {
		return {
			loading: false, //是显示加载
			title: '',

			editFormVisible: false, //控制Edit页面显示与隐藏
			payVisible: false,
			tempdingdanxinxi: '',
			id: '',
			radio: '',
			//detaitFormVsisisble

			isshdialog: false,

			editForm: {
			},
			user:[],
			username:'',
			cx:'',

			rules: {

			},
			rulesissh: {shhf: [{ required: true, message: 'Please fill in the reason for your reply', trigger: 'blur' }],},
			formInline: {
				page: 1,
				limit: 10,
			},


			listData: [],
			jianlitoudis:[],

			checkmenu: [],
			pageparm: {
				currentPage: 1,
				pageSize: 10,
				total: 0
			}
		};
	},
	computed:{
		headers(){
			return {"token":Session.get("token")}
		}
	},
	watch: {
			'$route' (to, from) {
				// 路由发生变化页面刷新
				this.$router.go(0);
			}
		},
	components: {
		Pagination
	},
	created() {

		if (!Session.get('userInfo')) return false;
		this.userInfo = Session.get('userInfo');
		this.username=localStorage.getItem("username");
		this.cx=localStorage.getItem("cx");
		if(this.userInfo.roles[0] == 'qiye'){this.formInline.qiyehao= this.username;}
		if(this.userInfo.roles[0] == 'yonghu'){this.formInline.yonghuming= this.username;}

		this.getdata(this.formInline)

	},
	methods: {

		//zxhifuff
		handleShenheList(){
				const jianlitoudis = this.jianlitoudis;
				if(jianlitoudis.length == 0){
					this.$message({
						type: 'error',
						message: 'Please select at least one'
					})
				}else {
					this.$confirm('Are you sure you want to review in bulk?', 'Info', {
						confirmButtonText: 'sure',
						cancelButtonText: 'Cancel',
						type: 'warning'
					}).then(() => {
						jianlitoudis.forEach(item=> {
							let data = {...item, issh: 1}
							jianlitoudiEdit(data).then(res => {})
						})
						this.getdata(this.formInline)
						this.$message({
							type: 'success',
							message: 'The batch review is successful！'
						})
					}).catch(() => {
						this.$message({
							type: 'info',
							message: 'Batch review has been canceled'
						})
					})
				}
			},
		getdata(parameter) {
			jianlitoudiList(parameter)
					.then(res => {
						this.loading = false
						if (res.success == false) {
							this.$message({
								type: 'info',
								message: res.msg
							})
						} else {
							this.listData = res.data.list



							// 分页赋值
							this.pageparm.currentPage = this.formInline.current
							this.pageparm.pageSize = this.formInline.currentNum
							this.pageparm.total = res.data.total
						}
					})
					.catch(err => {
						this.loading = false
						this.$message.error('Failed to load menu, please try again later!')
					})
		},

		// 分页插件事件
		callFather(parm) {
			this.formInline.current = parm.currentPage
			this.getdata(this.formInline)
		},

		// Search事件
		search() {
			this.getdata(this.formInline)
		},
		//显示Edit界面
		handleEdit: function (index, row) {
			this.editFormVisible = true
			if (row != undefined && row != 'undefined') {
				this.title = 'Modify resume delivery'
				this.editForm = row
			} else {
				this.title = 'AddResume delivery'
				this.editForm = {}
				this.editForm.yonghuming= this.username;
				this.editForm.xingming= this.userInfo.xingming;
				this.editForm.shouji= this.userInfo.shouji;

				//zixdonxgbianxhao1
			}
		},
		daochu(){
			axios.get('/jianlitoudi/getExcel', {
				responseType: 'blob',
				headers: { token: Session.get("token"), 'Content-Type': 'application/x-download' }
			}).then((res) => {
				if (res.status === 200) {
					var a = document.createElement('a')
					var blob = new Blob([res.data], { type: 'application/vnd.ms-excel' })
					var href = window.URL.createObjectURL(blob)
					a.href = href
					a.download = 'Resume delivery.xlsx'
					document.body.appendChild(a)
					a.click()
					document.body.removeChild(a)
					window.URL.revokeObjectURL(href)
				}
			}).catch((err) => {
				console.log(err)
			})
		},
		handleDaoruSuccess(res, file) {
				if(res.code == "0") {
					this.$message({
						type: 'success',
						message: 'The import was successful!'
					})
					this.getdata(this.formInline);
				}
			},
		beforeDaoruUpload(file) {
			const isJPG = file.type === 'application/vnd.ms-excel';
			if (!isJPG) {
				this.$message.error('upload只能是 excel 格式!');
			}
			return isJPG;
		},
		//zixdonxgbianxhao2

		handleDetail(index, row) {const w = window.open("about:blank");w.location.href = 'http://localhost:8080/#/jianlitoudidetail/'+row.id;},
		//liangbuedit
		// Edit、增加页面Save方法
		submitForm(editData) {

			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						jianlitoudiEdit(this.editForm).then(res => {
							this.editFormVisible = false

							this.loading = false
							if (res.code == '0') {
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: 'The resume has been submitted and modified successfully！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							this.editFormVisible = false
							this.loading = false
							this.getdata(this.formInline)
						if(err){
								this.$message.error(err)
							}else {
								this.$message.error('Operate失败，请稍后再试！')
							}
						})
					}else {
						jianlitoudiSave(this.editForm).then(res => {
							this.editFormVisible = false
							this.loading = false
							if (res.code == '0') {

								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: 'The resume was successfully delivered！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							this.editFormVisible = false
							this.loading = false
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
		// Delete公司
		deleteJianlitoudi(index, row) {
			this.$confirm('Are you sure you want to delete?', 'Info', {
				confirmButtonText: 'sure',
				cancelButtonText: 'Cancel',
				type: 'warning'
			}).then(() => {
				jianlitoudiDelete(row.id).then(res => {
					if (res.code == '0') {
						this.$message({
								type: 'success',
							message: 'The deletion is successful!'
						})
						this.getdata(this.formInline)
					} else {
						this.$message({
							type: 'info',
							message: res.msg
						})
					}
				}).catch(err => {
					this.loading = false
					this.$message.error('Operate失败，请稍后再试')
				})
			}).catch(() => {
				this.$message({
					type: 'info',
					message: 'Deleted from the program'
				})
			})
		},
		handleSelectionChange(val){
			this.jianlitoudis = val;
		},
		handleDeleteList(){
			const jianlitoudis = this.jianlitoudis;
			if(jianlitoudis.length == 0){
				this.$message({
					type: 'error',
					message: 'Please select at least one item to delete'
				})
			}else {
				this.$confirm('Are you sure you want to delete in bulk?', 'Info', {
					confirmButtonText: 'sure',
					cancelButtonText: 'Cancel',
					type: 'warning'
				}).then(() => {
					jianlitoudiDeleteList(jianlitoudis).then(res => {
						if (res.code == '0') {
							this.$message({
								type: 'success',
								message: 'The batch deletion is successful!'
							})
							this.getdata(this.formInline)
						} else {
							this.$message({
								type: 'info',
								message: res.msg
							})
						}
					}).catch(err => {
						this.loading = false
						this.$message.error('Operate失败，请稍后再试')
					})
				}).catch(() => {
					this.$message({
						type: 'info',
						message: 'Deleted from the program'
					})
				})
			}
		},
		//xuaxnzeshxifou
		hsgshenhe(index,row){
			this.isshdialog = true
			if (row != undefined && row != 'undefined') {
				this.titleissh = 'Audit'
				this.editForm = row
			} else {
				this.titleissh = 'Audit'
				this.editForm = {}
			}
			if(this.userInfo.roles[0] == 'user') {
				this.editForm.userId = this.userInfo.id;
			}
			//this.editForm.type = 'Audit'
		},
		closeisshdialog() {
			this.getdata(this.formInline)
			this.isshdialog = false
		},
		shenhe(editData) {
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						jianlitoudiEdit(this.editForm).then(res => {
							this.isshdialog = false
							this.loading = false
							if (res.code == '0') {
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: 'The Operate operation is successful！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							this.isshdialog = false
							this.loading = false
							this.getdata(this.formInline)
							if(err){
								this.$message.error(err)
							}else {
								this.$message.error('Operate失败，请 稍后再试！')
							}
						})
					}else {
						jianlitoudiSave(this.editForm).then(res => {
							this.isshdialog = false
							this.loading = false
							if (res.code == '0') {
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: 'The application was successful！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							this.isshdialog = false
							this.loading = false
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
		// 关闭Edit、增加弹出框
		closeDialog() {
			this.getdata(this.formInline)
			this.editFormVisible = false
		}
	},
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
