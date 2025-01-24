<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search">
			<el-form-item label=""><el-input size="small" v-model="formInline.gangweimingcheng" placeholder="Enter the Job Title"></el-input></el-form-item>
			<el-form-item label=""><el-input size="small" v-model="formInline.yonghuming" placeholder="Enter a username"></el-input></el-form-item>

			<el-form-item>
				<el-button size="small" type="warning" icon="el-icon-search" @click="search">Search</el-button>

				<el-button size="small" type="success" icon="el-icon-s-data" @click="daochu()" v-if="userInfo.roles[0] == 'guanliyuan'">Export</el-button>
				<el-button size="small" type="danger" icon="el-icon-delete" @click="handleDeleteList()" v-if="userInfo.roles[0] == 'guanliyuan'">Delete in bulk</el-button>

			</el-form-item>
			<el-form-item>
				<el-upload class="upload-demo" style="float: left; padding-right: 10px;" action='http://localhost:9999/xiaoxitongzhi/upload' :headers='headers' :show-file-list='false' :on-success='handleDaoruSuccess' :before-upload='beforeDaoruUpload' ><el-button size="small" type="info" icon="el-icon-sell" v-if="userInfo.roles[0] == 'guanliyuan'">Import</el-button></el-upload>
			</el-form-item>
		</el-form>

		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="Loading..." @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
			<el-table-column sortable prop="gangweimingcheng" label="Job Title"></el-table-column>
			<el-table-column sortable prop="yonghuming" label="Username"></el-table-column>
			<el-table-column sortable prop="xingming" label="name"></el-table-column>
			<el-table-column sortable prop="biaoti" label="Title"></el-table-column>
			<el-table-column sortable prop="tongzhishijian" label="Notification time"></el-table-column>
			<el-table-column sortable prop="qiyehao" label="Enterprise number"></el-table-column>
			<el-table-column sortable prop="fuzeren" label="Head"></el-table-column>
			<el-table-column sortable prop="lianxidianhua" label="Contact number"></el-table-column>

			<el-table-column sortable prop="addtime" label="Add Time" width="160">
				<template slot-scope="scope">
					<div>{{scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss')}}</div>
				</template>
			</el-table-column>

			<el-table-column align="center" label="Operate" min-width="160">
				<template slot-scope="scope">

					<!--liangbuan-->
					<el-button size="mini" type="success" @click="handleEdit(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == 'qiye'">Edit</el-button>
					<el-button size="mini" type="danger" @click="deleteXiaoxitongzhi(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == 'qiye'">Delete</el-button>
					<el-button size='mini' type='primary' @click="handleDetail(scope.$index, scope.row)">Detailed</el-button>
					<!--zhixfuanniu-->

				</template>
			</el-table-column>
		</el-table>
		<Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>

		<el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
			<el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
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
				<el-button size="small" @click="closeDialog">Cancel</el-button>
				<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">Save</el-button>
			</div>
		</el-dialog>


			<el-dialog :title="title" :visible.sync="detailFormVisible" width="60%" @click="closeDialogdetail">
			<table width="100%" border="0"  align="center" cellpadding="3" cellspacing="1" class="table table-striped table-bordered table-hover">
								<tr>
									<td width='11%' height='40px'>Job Title：</td><td width='39%'>{{editForm.gangweimingcheng}}</td>
     <td width='11%' height='40px'>Username：</td><td width='39%'>{{editForm.yonghuming}}</td></tr><tr>
     <td width='11%' height='40px'>name：</td><td width='39%'>{{editForm.xingming}}</td>
     <td width='11%' height='40px'>Title：</td><td width='39%'>{{editForm.biaoti}}</td></tr><tr>
     <td width='11%' height='40px'>content：</td><td width='39%'>{{editForm.neirong}}</td>
     <td width='11%' height='40px'>Notification time：</td><td width='39%'>{{editForm.tongzhishijian}}</td></tr><tr>
     <td width='11%' height='40px'>Enterprise number：</td><td width='39%'>{{editForm.qiyehao}}</td>
     <td width='11%' height='40px'>Head：</td><td width='39%'>{{editForm.fuzeren}}</td></tr><tr>
     <td width='11%' height='40px'>Contact number：</td><td width='39%'>{{editForm.lianxidianhua}}</td>
     <td>&nbsp;</td><td>&nbsp;</td></tr>
							</table>



			<div slot="footer" class="dialog-footer">
				<el-button size="small" @click="closeDialogdetail">关闭</el-button>

			</div>
		</el-dialog>
			<!--zhixfudhk-->
	</div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import { xiaoxitongzhiList, xiaoxitongzhiSave, xiaoxitongzhiDelete,xiaoxitongzhiEdit,xiaoxitongzhiDeleteList } from '@/api/xiaoxitongzhi/xiaoxitongzhiApi';


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
			detailFormVisible: false,



			editForm: {
			},
			user:[],
			username:'',
			cx:'',

			rules: {

			},

			formInline: {
				page: 1,
				limit: 10,
			},


			listData: [],
			xiaoxitongzhis:[],

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
		if(this.userInfo.roles[0] == 'yonghu'){this.formInline.yonghuming= this.username;}
		if(this.userInfo.roles[0] == 'qiye'){this.formInline.qiyehao= this.username;}

		this.getdata(this.formInline)

	},
	methods: {

		//zxhifuff
		handleShenheList(){
				const xiaoxitongzhis = this.xiaoxitongzhis;
				if(xiaoxitongzhis.length == 0){
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
						xiaoxitongzhis.forEach(item=> {
							let data = {...item, issh: 1}
							xiaoxitongzhiEdit(data).then(res => {})
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
			xiaoxitongzhiList(parameter)
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
				this.title = 'Modify Message notification'
				this.editForm = row
			} else {
				this.title = 'AddMessage notification'
				this.editForm = {}
				this.editForm.qiyehao= this.username;
				this.editForm.fuzeren= this.userInfo.fuzeren;
				this.editForm.lianxidianhua= this.userInfo.lianxidianhua;

				//zixdonxgbianxhao1
			}
		},
		daochu(){
			axios.get('/xiaoxitongzhi/getExcel', {
				responseType: 'blob',
				headers: { token: Session.get("token"), 'Content-Type': 'application/x-download' }
			}).then((res) => {
				if (res.status === 200) {
					var a = document.createElement('a')
					var blob = new Blob([res.data], { type: 'application/vnd.ms-excel' })
					var href = window.URL.createObjectURL(blob)
					a.href = href
					a.download = 'Message notification.xlsx'
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

		handleDetail: function (index, row) {
			this.detailFormVisible = true
			if (row != undefined && row != 'undefined') {
				this.title = 'Message notification details'
				this.editForm = row
			}

		},
		closeDialogdetail() {
				this.getdata(this.formInline)
				this.detailFormVisible = false
			},
		//liangbuedit
		// Edit、增加页面Save方法
		submitForm(editData) {

			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						xiaoxitongzhiEdit(this.editForm).then(res => {
							this.editFormVisible = false

							this.loading = false
							if (res.code == '0') {
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: 'The message notification is successful！'
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
						xiaoxitongzhiSave(this.editForm).then(res => {
							this.editFormVisible = false
							this.loading = false
							if (res.code == '0') {

								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: 'The message notifies that the Add is successful！'
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
		deleteXiaoxitongzhi(index, row) {
			this.$confirm('Are you sure you want to delete?', 'Info', {
				confirmButtonText: 'sure',
				cancelButtonText: 'Cancel',
				type: 'warning'
			}).then(() => {
				xiaoxitongzhiDelete(row.id).then(res => {
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
			this.xiaoxitongzhis = val;
		},
		handleDeleteList(){
			const xiaoxitongzhis = this.xiaoxitongzhis;
			if(xiaoxitongzhis.length == 0){
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
					xiaoxitongzhiDeleteList(xiaoxitongzhis).then(res => {
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
