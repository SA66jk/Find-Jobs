<template>
	<div class="form-adapt-container">
		<el-card shadow="hover" header="表单自适应演示(改变窗口查看效果)">
			<el-form :model="form" size="small" label-width="100px" class="mt35 mb35">
				<el-row :gutter="35">
					<el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="4" class="mb20">
						<el-form-item label="name">
							<el-input v-model="form.name" placeholder="Please enter a name" clearable></el-input>
						</el-form-item>
					</el-col>
					<el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="4" class="mb20">
						<el-form-item label="Job Seekers归属部门">
							<el-input v-model="form.email" placeholder="Please enter the account numberJob Seekers归属部门" clearable></el-input>
						</el-form-item>
					</el-col>
					<el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="4" class="mb20">
						<el-form-item label="登陆账户名">
							<el-input v-model="form.autograph" placeholder="Please enter the account number登陆账户名" clearable></el-input>
						</el-form-item>
					</el-col>
					<el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="4" class="mb20">
						<el-form-item label="职务">
							<el-select v-model="form.occupation" placeholder="请选择职务" clearable class="w100">
								<el-option label="计算机 / 互联网 / 通信" value="1"></el-option>
								<el-option label="生产 / 工艺 / 制造" value="2"></el-option>
								<el-option label="医疗 / 护理 / 制药" value="3"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="4" class="mb20">
						<el-form-item label="phone">
							<el-input v-model="form.phone" placeholder="Please enter your mobile phone" clearable></el-input>
						</el-form-item>
					</el-col>
					<el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="4" class="mb20">
						<el-form-item label="gender">
							<el-select v-model="form.sex" placeholder="请选择gender" clearable class="w100">
								<el-option label="man" value="1"></el-option>
								<el-option label="woman" value="2"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="4" class="mb20">
						<el-form-item label="loginPassword">
							<el-input v-model="form.phone1" placeholder="Please enter the account numberloginPassword" clearable></el-input>
						</el-form-item>
					</el-col>
					<el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="4" class="mb20">
						<el-form-item label="权限角色">
							<el-input v-model="form.phone2" placeholder="Please enter the account number权限角色" clearable></el-input>
						</el-form-item>
					</el-col>
					<el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="4" class="mb20">
						<el-form-item label="创建Job Seekers">
							<el-input v-model="form.phone3" placeholder="Please enter the account number创建Job Seekers" clearable></el-input>
						</el-form-item>
					</el-col>
					<el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="4" class="mb20">
						<el-form-item label="修改Job Seekers">
							<el-input v-model="form.phone4" placeholder="Please enter the account number修改Job Seekers" clearable></el-input>
						</el-form-item>
					</el-col>
					<el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="4" class="mb20">
						<el-form-item label="所属Job Seekers">
							<el-input v-model="form.phone5" placeholder="Please enter the account number所属Job Seekers" clearable></el-input>
						</el-form-item>
					</el-col>
					<el-col :xs="24" :sm="12" :md="8" :lg="6" :xl="4" class="mb20">
						<el-form-item label="所属部门">
							<el-input v-model="form.phone6" placeholder="Please enter the account number所属部门" clearable></el-input>
						</el-form-item>
					</el-col>
					<el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
						<el-form-item>
							<el-button type="primary" icon="iconfont icon-biaodan">update个人信息</el-button>
						</el-form-item>
					</el-col>
				</el-row>
			</el-form>
		</el-card>
	</div>
</template>

<script>
export default {
	name: 'pagesFormAdapt',
	data() {
		return {
			form: {},
		};
	},
};
</script>
