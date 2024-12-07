<template>
  <div style="width: 1800px; margin: 0 auto;">
<!--    <div id="services" class="text-center">
      <div class="container">
        <div class="section-title center">
          <h2>关于 <strong>我们</strong></h2>
          <hr>
        </div>
        <div class="space"></div>
        <div class="row">
          <div class="col-md-3 col-sm-6 service"><i class="fa fa-laptop"></i>
            <h4><strong>specialized团队</strong></h4>
            <p>
              我们拥有一支经验丰富、技术精湛的团队。<br>他们具备深厚的行业知识和实践经验，能够为您提供卓越的服务。
            </p>
          </div>
          <div class="col-md-3 col-sm-6 service"><i class="fa fa-code"></i>
            <h4><strong>创新技术</strong></h4>
            <p>
              <br>我们持续关注行业动态，引进和采用最新的技术和工具，确保我们的解决方案始终处于行业前沿。

            </p>
          </div>
          <div class="col-md-3 col-sm-6 service"><i class="fa fa-rocket"></i>
            <h4><strong>质量保证</strong></h4>
            <p>
              我们严格把控产品质量，确保每一项交付都能达到甚至超越您的期望。
            </p>
          </div>
          <div class="col-md-3 col-sm-6 service"><i class="fa fa-bullseye"></i>
            <h4><strong>定制化服务</strong></h4>
            <p>我们理解每个客户的独特需求。<br>因此，我们提供量身定制的解决方案，以满足您的具体要求。</p>
          </div>
        </div>
      </div>
    </div>-->
    <div id="works">
  <div class="container">
	<div class="section-title text-center center">
	  <h2>Post <strong>Recommendation</strong></h2>
	  <hr>
	  <div class="clearfix"></div>
	</div>
	<div class="categories">
	  <div class="clearfix"></div>
	</div>
	<div class="row">
	  <div class="portfolio-items">

		<div class="col-sm-6 col-md-3 col-lg-3 web" v-for="item in objssp" :key="item.id">
		  <div class="portfolio-item">
			<div class="hover-bg">
			  <div class="hover-text">
				<router-link :to="`/gangweixinxidetail/`+item.id" class="shadow">
				  <h4>{{ item.gangweimingcheng }}</h4>
				  <small>{{ item.addtime }}</small>
				  <div class="clearfix"></div>
				  <i class="fa fa-search"></i>
				</router-link>
			  </div>
			  <img :src="`/api/`+item.tupian" class="img-responsive" width="420" height="260"></div>
		  </div>
		</div>

	  </div>
	</div>
  </div>
</div>
<!--    <div id="about">
      <div class="container">
        <div class="section-title text-center center">
          <h2><strong>specialized</strong> 技能</h2>
          <hr>
        </div>
        <div class="row">
          <div class="col-md-6"><img src="../assets/images/about.png" class="img-responsive"></div>
          <div class="col-md-6">
            <div class="about-text"><i class="fa fa-users"></i>
              <div class="padding-left"><h4>高效执行</h4>
                <p>
                  深知每位客户的需求是独特的。因此，我们提供定制化的服务和解决方案，确保满足客户的期望。</p>
              </div>
              <i class="fa fa-magic"></i>
              <div class="padding-left"><h4>良好口碑</h4>
                <p>多年来，我们已成功帮助众多客户实现目标，赢得了良好的口碑和信誉。</p></div>
              <i class="fa fa-check-square-o"></i>
              <div class="padding-left"><h4>贴心客服</h4>
                <p>我们始终关注客户的反馈，提供全方位的售后服务，确保您的问题得到及时解决。</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>-->
<!--    <div id="achivements" class="section dark-bg">
      <div class="container">
        <div class="row">
          <div class="col-md-3 col-sm-3">
            <div class="achivement-box">
              <i class="fa fa-smile-o"></i>
              <span class="count">卓越品质</span>
              <h4>
                我们注重产品品质和服务质量。我们采用先进的生产工艺和严格的质量控制体系，确保每一个产品都符合最高标准，并且用心为客户提供满意的售后服务。</h4>
            </div>
          </div>
          <div class="col-md-3 col-sm-3">
            <div class="achivement-box">
              <i class="fa fa-code"></i>
              <span class="count">创新能力</span>
              <h4>
                我们不断追求创新，积极引入新技术和新理念，以满足不断变化的市场需求。我们持续投入研发，推出具有竞争力的新产品，为客户提供更多选择和更好的体验。</h4>
            </div>
          </div>
          <div class="col-md-3 col-sm-3">
            <div class="achivement-box">
              <i class="fa fa-check-square-o"></i>
              <span class="count">客户至上</span>
              <h4>
                客户的满意是我们最大的追求。我们始终将客户需求放在首位，倾听客户意见，不断改进和优化产品和服务，确保客户得到最好的体验和价值。</h4>
            </div>
          </div>
          <div class="col-md-3 col-sm-3">
            <div class="achivement-box">
              <i class="fa fa-trophy"></i>
              <span class="count">可靠性与稳定性</span>
              <h4>
                我们注重产品的可靠性和稳定性。无论是产品设计还是供应链管理，我们都采取严格的措施，确保产品质量和供货稳定，让客户放心选择我们的产品。</h4>
            </div>
          </div>
        </div>
      </div>
    </div>-->
	<div id="team" class="text-center">
  <div class="container">
	<div class="section-title center">
	  <h2>enterprise <strong></strong></h2>
	  <hr>
	  <p>Innovation leads, create the future together!</p>
	</div>
	<div id="row">

	  <div class="col-md-3 col-sm-6" v-for="item in objstx" :key="item.id">
		<router-link :to="`/qiyexinxidetail/`+item.id" class="shadow">
		  <div class="thumbnail">
			<img :src="`/api/`+item.qiyezhaopian" class="img-circle team-img">
			<div class="caption">
			  <h3>{{item.qiyemingcheng}}</h3>
			  <p>{{item.addtime}}</p>
			</div>
		  </div>
		</router-link>
	  </div>

	</div>
  </div>
</div>
<!--    <div id="testimonials" class="text-center">
      <div class="container">
        <div class="section-title center">
          <h2>自我 <strong>评价</strong></h2>
          <hr>
          <p style="text-align: left;width: 1000px; margin: 0 auto;">
            我是一个充满热情和责任心的人，以下是我的自我评价：<br>

            specialized能力：我具备扎实的specialized知识和技能，在我所从事的领域中有着丰富的经验和深入的理解。<br>

            学习能力：我对于学习持续保持着高度的热情和求知欲，不断追求新知识和技能的提升，以适应不断变化的环境和需求。<br>

            解决问题：我具备良好的问题解决能力，能够分析和解决复杂的问题。我善于思考，注重细节，能够找到切实可行的解决方案。<br>

            团队合作：我具备出色的团队合作能力，能够与不同背景和specialized的人合作，共同完成任务和达成目标。我善于沟通和协调，能够有效地与他人合作。<br>

            自我驱动：我能够自我激励和管理，对于工作和任务有着高度的责任感和自律性。我具备良好的时间管理能力，能够有效地组织和安排工作。<br>

            适应力：我适应能力强，能够迅速适应新的环境和任务。我灵活应对变化，具备快速学习和适应新技术、新流程的能力。<br>

            总的来说，我是一个积极进取、富有激情和责任心的人，具备specialized能力、学习能力、问题解决能力、团队合作能力、自我驱动能力和适应力，致力于不断提升自己，并为团队和组织做出积极的贡献。
          </p>
        </div>
      </div>
    </div>-->


  </div>
</template>
<script>
import {mapActions} from "vuex";

export default {
  data() {
    return {
      objssp: [],
      objstx: [],
      wbjxwtz1: [],
    };
  },
  watch: {
    '$route'(to, from) {
      this.$router.go(0)
    },
  },
  created() {
    let user = localStorage.getItem("user");
    if (user) {
      this.userInfo = JSON.parse(localStorage.getItem("user"));
    }
    this.loadTablesp(8);
	this.loadTabletx(4);
  },

  methods: {
    ...mapActions(["setUser", "setShowLogin", "setShoppingCart"]),
    goUrl() {
      window.location.href = 'http://localhost:9999'
    },

    loadTablesp(ns) {
        this.$axios
                .post("/api/front/gangweixinxi", {})
                .then(res => {
                  let data = res.data.data.list;
                  let filteredData = [];
                  let i=0;
                  data.forEach(item => {
                    i++;
                    if(i<=ns)
                    {
                      filteredData.push(item);
                    }
                  });
                  this.objssp = filteredData;
                });
      },
    loadTabletx(ns) {
        this.$axios
                .post("/api/front/qiyexinxi", {})
                .then(res => {

                  let data = res.data.data.list;
                  let filteredData = [];
                  let i=0;
                  data.forEach(item => {
                    i++;
                    if(i<=ns)
                    {
                      filteredData.push(item);
                    }
                  });
                  this.objstx = filteredData;
                });
      },


  }
};
</script>
<style scoped>
@import "../assets/css/index.scss";


.message-item {
  margin-bottom: 20px;
}

.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  display: flex;
  justify-content: center;
  margin-top: 13px;
  line-height: 12px;
}

.button {
  width: 100%;
  text-align: center;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.el-row {
  margin-bottom: 20px;

}

last-child {
  margin-bottom: 0;
}

.el-col {
  border-radius: 4px;
}

.bg-purple {
  background: #d3dce6;
}

.bg-purple-light {
  background: #e5e9f2;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}

.info-item {
  display: flex;
  font-size: 13px;
  color: #606266;
  height: 28px;
  line-height: 28px;
}

.info-item :hover {
  color: #303133;
  cursor: pointer;
}

.info-item-left {
  flex: 1;
  flex-shrink: 0;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}

.rizhuti_v2-widget-search-bg > .container {
  max-width: none !important;
  padding: 0 !important;
}

.container, .container-fluid, .container-lg, .container-md, .container-sm, .container-xl {
  width: 100%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}

.module.search-bg {
  z-index: 2 !important;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  min-height: calc(100vh - 70vh);
  position: relative;
  text-align: center;
  background-repeat: no-repeat;
  background-position: 50%;
  background-size: cover;
}

.module.search-bg .search-bg-overlay {
  height: 100%;
  width: 100%;
  top: 0;
  left: 0;
  position: absolute;
  filter: brightness(100%) contrast(100%) saturate(100%) blur(0px) hue-rotate(0deg);
  background-color: #191e4b;
  opacity: 0.5;
  transition: background 0.3s, border-radius 0.3s, opacity 0.3s;
}

.module.search-bg .container {
  z-index: 1;
  margin: auto;
  padding-bottom: 140px;
  padding-top: 140px;
  max-width: 820px;
}

.module.search-bg .search-title {
  color: #fff;
  letter-spacing: 2px;
  font-size: 24px;
}

.module.search-bg .search-desc {
  color: #fff;
  margin-bottom: 25px;
}

.module.search-bg .search-form {
  max-width: 100%;
}

.search-form form {
  display: flex;
  -ms-flex-flow: row nowrap;
  flex-flow: row nowrap;
  -ms-flex-align: center;
  align-items: center;
  -ms-flex-pack: justify;
  justify-content: space-between;
  width: 100%;
  border-radius: 50px;
}

.search-form .search-fields {
  background-color: #ffffff;
  position: relative;
  display: inline-block;
  flex: 1;
  vertical-align: top;
  background: #fff;
  border-radius: 30px;
  opacity: 0.8;
  overflow: hidden;
}

.search-form .search-fields input {
  display: block;
  height: 50px;
  line-height: 20px;
  width: 100%;
  border: 2px solid #fff;
  position: relative;
  z-index: 100;
  margin: 0;
  font-size: 16px;
  outline: 0;
  -webkit-appearance: none;
}

.search-form .search-fields button {
  position: absolute;
  height: 54px;
  width: 50px;
  right: 0;
  top: 0;
  z-index: 1000;
  border: none !important;
  background: 0 0 !important;
  max-height: 50px;
}

.module.search-bg .popula-search-key {
  text-align: left;
  color: #fff;
  margin-top: 10px;
  opacity: 0.5;
}

.module.search-bg .popula-search-key > a {
  color: #fff;
}

.modular-title-1 .section-title {
  font-size: 24px;
  letter-spacing: .5px;
  margin-bottom: 30px;
  text-transform: uppercase;
}

.image {
  width: 100%;
  display: block;
  max-height: 120px;
  min-height: 120px;
}

.clearfix {
  margin: 0 auto;
  width: 1200px;
  display: flex;

  flex-wrap: wrap;
//align-items: center;
}

.clearfix > li {
  width: 30%;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}


.title {
  font-size: 14px;
  letter-spacing: -0.2px;
  margin-bottom: 0;
  overflow: hidden;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  white-space: normal;
  height: 36px;
  line-height: 18px;
}

.clear {
  clear: both;
}

.el-form-item {
  margin-bottom: 0px !important;
}

.section {
  width: 100%;

  overflow: hidden;
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
}

h3 {
  display: flex;
  flex-direction: column;
  align-items: center;
}


</style>
