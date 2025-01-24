<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search">
			<el-form-item label=""><el-input size="small" v-model="formInline.yonghuming" placeholder="Enter a username"></el-input></el-form-item>
			<el-form-item label=""><el-input size="small" v-model="formInline.cheng" placeholder="输入昵称"></el-input></el-form-item>

			<el-form-item>
				<el-button size="small" type="primary" icon="el-icon-search" @click="search">Search</el-button>
				<el-button size="small" type="primary" icon="el-icon-plus" @click="handleEdit()" v-if="userInfo.roles[0] == 'jumin'">Add</el-button>

				<el-button size="small" type="danger" icon="el-icon-delete" @click="handleDeleteList()" v-if="userInfo.roles[0] == 'guanliyuan'">Delete in bulk</el-button>
			</el-form-item>
		</el-form>
		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="Loading..." @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
<!--			<el-table-column sortable prop="yonghuming" label="Username"></el-table-column>-->
			<el-table-column sortable prop="cheng" label="昵称"></el-table-column>
<!--			<el-table-column align='center' sortable prop='touxiang' label='avatar' width='120'><template slot-scope='scope'><el-image :src='scope.row.touxiang' style='height:70px'/></template></el-table-column>-->
			<el-table-column sortable prop="biaoti" label="Title"></el-table-column>

			<el-table-column sortable prop="addtime" label="Add Time" width="160">
				<template slot-scope="scope">
					<div>{{scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss')}}</div>
				</template>
			</el-table-column>

			<el-table-column align="center" label="Operate" min-width="160">
				<template slot-scope="scope">

					<!--liangbuan-->
<!--					<el-button size="mini" type="success" @click="handleEdit(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == 'jumin'">Edit</el-button>-->
					<el-button size="mini" type="danger" @click="deleteLiuyanban(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == 'jumin'">Delete</el-button>
<!--					<el-button size='mini' type='primary' @click="handleDetail(scope.$index, scope.row)">Detailed</el-button>-->

				</template>
			</el-table-column>
		</el-table>
		<Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>

		<el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
			<el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
				<el-form-item  label="Username" prop="yonghuming"><el-input size="small" v-model="editForm.yonghuming" auto-complete="off" placeholder="Please enter a username" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="昵称" prop="cheng"><el-input size="small" v-model="editForm.cheng" auto-complete="off" placeholder="Please enter the account number昵称" style='width:50%'></el-input></el-form-item>
		<el-form-item  label='avatar' prop='touxiang'><el-upload class='avatar-uploader' action='http://localhost:9999/files/upload' :headers='headers' :show-file-list='false' :on-success='handleTouxiangSuccess' :before-upload='beforeTouxiangUpload'><img v-if='editForm.touxiang' :src='editForm.touxiang' class='avatar'><i v-else class='el-icon-plus avatar-uploader-icon'></i></el-upload></el-form-item>
		<el-form-item  label="Title" prop="biaoti"><el-input size="small" v-model="editForm.biaoti" auto-complete="off" placeholder="Please enter a title" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="content" prop="neirong"><el-input type="textarea" size="small" v-model="editForm.neirong" auto-complete="off" placeholder="Please enter your content" style='width:100%'></el-input></el-form-item>
		<el-form-item  label="Reply" prop="huifu"><el-input type="textarea" size="small" v-model="editForm.huifu" auto-complete="off" placeholder="Please enter a reply" style='width:100%'></el-input></el-form-item>


			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button size="small" @click="closeDialog">Cancel</el-button>
				<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">Save</el-button>
			</div>
		</el-dialog>



	</div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import { liuyanbanList, liuyanbanSave, liuyanbanDelete,liuyanbanEdit,liuyanbanDeleteList } from '@/api/liuyanban/liuyanbanApi';


import {Session} from "@/utils/storage";
export default {
	name: 'user',
	data() {
		return {
			loading: false, //是显示加载
			title: '',

			editFormVisible: false, //控制Edit页面显示与隐藏
			detailFormVisible: false,


			editForm: {
			},
			user:[],

			rules: {

			},

			formInline: {
				page: 1,
				limit: 10,
			},


			listData: [],
			liuyanbans:[],

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
		if(this.userInfo.roles[0] == 'jumin'){this.formInline.yonghuming= this.userInfo.zhanghao;}

		this.getdata(this.formInline)

	},
	methods: {
		getdata(parameter) {
			liuyanbanList(parameter)
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
				this.title = '修改留言板'
				this.editForm = row
			} else {
				this.title = 'Add留言板'
				this.editForm = {}

				this.editForm.yonghuming= this.userInfo.yonghuming;
				this.editForm.cheng= this.userInfo.cheng;

			}
		},

		handleDetail: function (index, row) {
			this.detailFormVisible = true
			if (row != undefined && row != 'undefined') {
				this.title = '留言板Detailed'
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
						liuyanbanEdit(this.editForm).then(res => {
							this.editFormVisible = false

							this.loading = false
							if (res.code == '0') {
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: '留言板修改成功！'
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
						liuyanbanSave(this.editForm).then(res => {
							this.editFormVisible = false
							this.loading = false
							if (res.code == '0') {

								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: '留言板Add success！'
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
		deleteLiuyanban(index, row) {
			this.$confirm('Are you sure you want to delete?', 'Info', {
				confirmButtonText: 'sure',
				cancelButtonText: 'Cancel',
				type: 'warning'
			}).then(() => {
				liuyanbanDelete(row.id).then(res => {
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
			this.liuyanbans = val;
		},
		handleDeleteList(){
			const liuyanbans = this.liuyanbans;
			if(liuyanbans.length == 0){
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
					liuyanbanDeleteList(liuyanbans).then(res => {
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
