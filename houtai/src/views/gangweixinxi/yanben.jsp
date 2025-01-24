<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search">
			<el-form-item label=""><el-input size="small" v-model="formInline.gangweimingcheng" placeholder="�����λ����"></el-input></el-form-item>			
			<el-form-item>
				<el-button size="small" type="primary" icon="el-icon-search" @click="search">����</el-button>
			</el-form-item>
		</el-form>
		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="ƴ��������" @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
			<el-table-column sortable prop="gangweimingcheng" label="��λ����"></el-table-column>			<el-table-column sortable prop="gongzuodidian" label="�����ص�"></el-table-column>			<el-table-column sortable prop="gongzuoshijian" label="����ʱ��"></el-table-column>			<el-table-column sortable prop="xuqiurenshu" label="��������"></el-table-column>			<el-table-column sortable prop="xinzi" label="н��"></el-table-column>			<el-table-column align='center' prop='tupian' label='ͼƬ' width='120'><template slot-scope='scope'><el-image :src='scope.row.tupian' style='height:70px'  v-if="scope.row.tupian"/><img src="../../../static/images/guanli.jpg" style='height:70px' v-else/></template></el-table-column>			<el-table-column sortable prop="qiyehao" label="��ҵ��"></el-table-column>			<el-table-column sortable prop="qiyemingcheng" label="��ҵ����"></el-table-column>			<el-table-column sortable prop="fuzeren" label="������"></el-table-column>			<el-table-column sortable prop="lianxidianhua" label="��ϵ�绰"></el-table-column>			
			<el-table-column sortable prop="addtime" label="���ʱ��" width="160">
				<template slot-scope="scope">
					<div>{{scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss')}}</div>
				</template>
			</el-table-column>
			
			<el-table-column align="center" label="����" min-width="160">
				<template slot-scope="scope">
					<!--lianjie1-->
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
			loading: false, //����ʾ����
			title: '',
			editFormVisible: false, //���Ʊ༭ҳ����ʾ������
			
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
				// ·�ɷ����仯ҳ��ˢ��
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
							
							// ��ҳ��ֵ
							this.pageparm.currentPage = this.formInline.current
							this.pageparm.pageSize = this.formInline.currentNum
							this.pageparm.total = res.data.total
						}
					})
					.catch(err => {
						this.loading = false
						this.$message.error('�˵�����ʧ�ܣ����Ժ����ԣ�')
					})
		},
		//qixuzhijixsuan3
		// ��ҳ����¼�
		callFather(parm) {
			this.formInline.current = parm.currentPage
			this.getdata(this.formInline)
		},
		//xia2sui1
		// �����¼�
		search() {
			this.getdata(this.formInline)
		},
		//��ʾ�༭����
		
		addSalary(index,row){
				this.$router.push({
					name:'xmkuaixAdd',
					params:{
						id:row.id
					}
				})
			},
		// �༭������ҳ�汣�淽��
		
		// ɾ����˾
		
	
		
		
		
		
		// �رձ༭�����ӵ�����
		
	},
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
