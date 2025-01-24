<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search">
			<el-form-item label=""><el-input size="small" v-model="formInline.gangweimingcheng" placeholder="Enter the Job Title"></el-input></el-form-item>

			<el-form-item>
				<el-button size="small" type="primary" icon="el-icon-search" @click="search">Search</el-button>
			</el-form-item>
		</el-form>
		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="Loading..." @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
			<el-table-column sortable prop="gangweimingcheng" label="Job Title"></el-table-column>
			<el-table-column sortable prop="gongzuodidian" label="Place of work"></el-table-column>
			<el-table-column sortable prop="gongzuoshijian" label="working hours"></el-table-column>
			<el-table-column sortable prop="xuqiurenshu" label="Number of people required"></el-table-column>
			<el-table-column sortable prop="xinzi" label="Salary"></el-table-column>
			<el-table-column align='center' prop='tupian' label='format' width='120'><template slot-scope='scope'><el-image :src='scope.row.tupian' style='height:70px'  v-if="scope.row.tupian"/><img src="../../../static/images/guanli.jpg" style='height:70px' v-else/></template></el-table-column>
			<el-table-column sortable prop="qiyehao" label="Enterprise number"></el-table-column>
			<el-table-column sortable prop="qiyemingcheng" label="The name of the business"></el-table-column>
			<el-table-column sortable prop="fuzeren" label="Head"></el-table-column>
			<el-table-column sortable prop="lianxidianhua" label="Contact number"></el-table-column>

			<el-table-column sortable prop="addtime" label="Add Time" width="160">
				<template slot-scope="scope">
					<div>{{scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss')}}</div>
				</template>
			</el-table-column>

			<el-table-column align="center" label="Operate" min-width="160">
				<template slot-scope="scope">
					<el-button size="mini"  type="danger" @click="addSalary(scope.$index, scope.row)">AddResume delivery</el-button>
				</template>
			</el-table-column>
		</el-table>
		<Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>

	</div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import { gangweixinxiList, gangweixinxiSave, gangweixinxiDelete,gangweixinxiEdit,gangweixinxiDeleteList } from '@/api/gangweixinxi/gangweixinxiApi';


import {Session} from "@/utils/storage";
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
			username:'',
			cx:'',

			rules: {

			},

			formInline: {
				page: 1,
				limit: 10,
			},


			listData: [],
			gangweixinxis:[],
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

		this.getdata(this.formInline)

	},
	methods: {
		getdata(parameter) {
			gangweixinxiList(parameter)
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
		//qixuzhijixsuan3
		// 分页插件事件
		callFather(parm) {
			this.formInline.current = parm.currentPage
			this.getdata(this.formInline)
		},
		//xia2sui1
		// Search事件
		search() {
			this.getdata(this.formInline)
		},
		//显示Edit界面

		addSalary(index,row){
				this.$router.push({
					name:'jianlitoudiAdd',
					params:{
						id:row.id
					}
				})
			},
		// Edit、增加页面Save方法

		// Delete公司






		// 关闭Edit、增加弹出框

	},
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
