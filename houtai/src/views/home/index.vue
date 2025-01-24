<template>
<!--	<div class="home">-->
<!--		&lt;!&ndash; Job Seekers信息 &ndash;&gt;-->
<!--		<el-row :gutter="15">-->
<!--			<el-col :md="24" :lg="16" :xl="16" class="mb15">-->
				<el-card shadow="hover" >

<!--   修改成你的信息     -->
					<table width="100%" height="193" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#D9E9FF" style="border-collapse:collapse">
						<TBODY>
						<TR
								align=middle bgColor=#ffffff>
							<td colspan="2" bgColor=#fbf6f2><strong>Welcome login system</strong></td>
						</TR>
						<TR   align=middle
							  bgColor=#ffffff>
							<TD width="10%" align="left" >System author：</TD>
							<TD width="41%"  align="left" ><font class="t4">xxxxxx</font></TD>
						</TR>
						<TR   align=middle
							  bgColor=#ffffff>
							<TD align="left"  >Instructors：</TD>
							<TD  align="left" ><font class="t4">xxxxxx</font></TD>
						</TR>
						<TR   align=middle
							  bgColor=#ffffff>
							<TD align="left"  >Contact：</TD>
							<TD  align="left" ><font class="t41">xxxxxxxxxxxxxxx</font></TD>
						</TR>
						</TBODY>
					</TABLE>
				</el-card>
<!--			</el-col>-->
<!--		</el-row>-->

<!--	</div>-->
</template>

<script>
import * as echarts from 'echarts';
import Scroll from 'vue-seamless-scroll';
import { CountUp } from 'countup.js';
import { Session } from '@/utils/storage';
import { formatAxis, formatDate } from '@/utils/formatTime';
import { recommendList, chartsRightList, newsInfoList, dailyMessage } from './mock';
export default {
	name: 'home',
	components: { Scroll },
	data() {
		return {
			recommendList,
			userInfo: {},
			dailyMessage: {},
			charts: {
				theme: '',
				bgColor: '',
			},
			global: {
				homeChartOne: null,
				homeChartTwo: null,
				homeCharThree: null,
				dispose: [null, '', undefined],
			},
		};
	},
	created() {
		this.initUserInfo();
		this.initDailyMessage();
	},
	computed: {
		currentTime() {
			return formatAxis(new Date());
		},
		optionSingleHeight() {
			return {
				singleHeight: 28,
				limitMoveNum: 8,
				waitTime: 2000,
			};
		},
		getUserInfos() {
			return this.$store.state.userInfos.userInfos;
		},
	},
	methods: {
		// 随机语录
		initDailyMessage() {
			this.dailyMessage = dailyMessage[Math.floor(Math.random() * dailyMessage.length)];
		},
		// 初始化login信息
		initUserInfo() {
			if (!Session.get('userInfo')) return false;
			this.userInfo = Session.get('userInfo');
			this.userInfo.time = formatDate(new Date(this.userInfo.time), 'YYYY-mm-dd HH:MM:SS');
		},
		// Message notification当前项点击
		onNewsInfoListClick(v) {
			window.open(v.link);
		},
	},
	watch: {
		// 监听 vuex 数据变化
		'$store.state.themeConfig.themeConfig.isIsDark': {
			handler(isIsDark) {
				this.$nextTick(() => {
					this.charts.theme = isIsDark ? 'dark' : '';
					this.charts.bgColor = isIsDark ? 'transparent' : '';
					setTimeout(() => {
						//this.initHomeStock();
					}, 500);
					setTimeout(() => {
						//this.initHomeLaboratory();
					}, 700);
					setTimeout(() => {
						//this.initHomeOvertime();
					}, 1000);
				});
			},
			deep: true,
			immediate: true,
		},
	},
};
</script>

<style scoped lang="scss">
@import './index.scss';
</style>
