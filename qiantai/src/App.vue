<template id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
  <div>
    <!-- Navigation -->
    <nav class="navbar navbar-custom navbar-fixed-top header-menu " role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
            <i class="fa fa-bars"></i>
          </button>
          <a class="navbar-brand page-scroll" href="#page-top">Recruitment system platform</a>
        </div>

		<div class="collapse navbar-collapse navbar-right navbar-main-collapse" style="margin-left: 80px">
  <ul class="nav navbar-nav menu" >
	<li class="menu-item hover"><a href="/">Home<span>&nbsp;</span></a></li>

		<li class="menu-item "><a style="cursor:pointer">company<span>&nbsp;</span></a>
	  <ul class="sub-menu">
		<li class="menu-item"><router-link :to="`/qiyexinxilisttp/`" >company</router-link></li>
	  </ul>
	</li><li class="menu-item "><a style="cursor:pointer">information<span>&nbsp;</span></a>
	  <ul class="sub-menu">
		<li class="menu-item"><router-link :to="`/jianlixinxi/`" >information</router-link></li>
	  </ul>
	</li><li class="menu-item "><a style="cursor:pointer">Job<span>&nbsp;</span></a>
	  <ul class="sub-menu">
		<li class="menu-item"><router-link :to="`/gangweixinxilisttp/`" >Job</router-link></li>
	  </ul>
	</li><li class="menu-item "><a style="cursor:pointer">News<span>&nbsp;</span></a>
	  <ul class="sub-menu">
		<li class="menu-item"><router-link :to="`/xinwentongzhi/Career guidance/`" >Career guidance</router-link></li> <li class="menu-item"><router-link :to="`/xinwentongzhi/Innovation and entrepreneurship/`" >Innovation and entrepreneurship</router-link></li>
	  </ul>
	</li>
<!--    <li class="menu-item "><a style="cursor:pointer">在线留言<span>&nbsp;</span></a>-->
<!--	  <ul class="sub-menu">-->
<!--		<li class="menu-item"><router-link :to="`/Liuyan/`" >在线留言</router-link></li>-->
<!--	  </ul>-->
<!--	</li>&lt;!&ndash;yoxulixuyaxn&ndash;&gt;-->
  </ul>
</div>

        <div style="width: 360px; height: 50px;float: right">
          <div style=" float: left; margin-left: 10px; " class="dd">
            <li v-if="!this.$store.getters.getUser" style="float:left">
              <el-button type="text" @click="login" style="color: #fff;
      display: inline-block;
      text-transform: uppercase;
      text-decoration: none;
      background: #dc9a26;
      text-align: center;
      padding: 6px 30px;
      font-weight: bold;">login
              </el-button>
              <span class="sep">|</span>
              <el-button type="text" @click="register = true" style="color: #fff;
      display: inline-block;
      text-transform: uppercase;
      text-decoration: none;
     background: #dc9a26;
      text-align: center;
      padding: 6px 30px;
      font-weight: bold;">enroll
              </el-button>
            </li>
            <li v-else>
              <font color="white"> Welcome {{ username }} [{{ cx }}]</font>&nbsp;
              <el-button type="text" @click="logout" style="color: #fff;
      display: inline-block;
      text-transform: uppercase;
      text-decoration: none;
     background: #dc9a26;
      text-align: center;
      padding: 6px 30px;
      font-weight: bold;">quit
              </el-button>
              <router-link :to="`/Collect/`" class="el-button el-button--text" style="color: #fff;
      display: inline-block;
      text-transform: uppercase;
      text-decoration: none;
       background:#dc9a26;
      text-align: center;
      padding: 6px 30px;
      font-weight: bold;">
                My favorites
              </router-link>
              <el-popover placement="top" width="180" v-model="visible">
                <p>Are you sure about quit login?</p>
                <div style="text-align: right; margin: 10px 0 0">
                  <el-button size="mini" type="text" @click="visible = false">Cancel</el-button>
                  <el-button type="primary" size="mini" @click="logout">sure</el-button>
                </div>
              </el-popover>
            </li>
          </div>
        </div>
      </div>
    </nav>

    <header class="intro">
      <div class="intro-body" style="height: 450px">
        <el-carousel style="z-index: -1; height:460px; .el-carousel--horizontal:overflow-x: inherit;">
          <el-carousel-item v-for="item in carouselItems" :key="item.id" style="height:460px">
            <img :src="'/api/'+item.tupian" style="height: 460px; width: 100%"/>
          </el-carousel-item>
        </el-carousel>
      </div>
    </header>



    <!-- login模块 -->
    <MyLogin></MyLogin>
    <!-- enroll模块 -->
    <MyRegister :register="register" @fromChild="isRegister"></MyRegister>

    <!-- 主要区域容器 -->
    <el-main>
      <keep-alive>
        <router-view></router-view>
      </keep-alive>
    </el-main>
    <!-- 主要区域容器END -->



    <div id="contact" class="text-center">
      <div class="container">
        <div class="section-title center">
          <h2><strong>contact</strong> manner</h2>
          <hr>
        </div>
        <div class="col-md-8 col-md-offset-2">
          <div class="col-md-4">
            <i class="fa fa-map-marker fa-2x"></i>
            <p>1234 Elm Street, Los Angeles, CA, USA</p>
          </div>
          <div class="col-md-4">
            <i class="fa fa-envelope-o fa-2x"></i>
            <p>contact@mywebsite.com</p>
          </div>
          <div class="col-md-4">
            <i class="fa fa-whatsapp fa-2x"></i>
            <p>WhatsApp: +1 234 567 8900</p>
          </div>
          <hr>
          <div class="clearfix"></div>
        </div>


      </div>
    </div>
  </div>

</template>

<script>
import {mapActions} from "vuex";
import {mapGetters} from "vuex";

export default {
  beforeUpdate() {
    this.activeIndex = this.$route.path;
  },
  data() {
    return {
      carouselItems: [], // 存储轮播图数据
      activeIndex: "", // 头部导航栏选中的标签
      search: "", // Search条件
      register: false, // 是否显示enroll组件
      visible: false, // 是否quit login
      username: '',
      cx: '',
    };
  },
  created() {
    // 获取浏览器localStorage，判断Job Seekers是否已经login
    if (localStorage.getItem("user")) {
      // 如果已经login，设置vuexlogin状态
      this.setUser(JSON.parse(localStorage.getItem("user")));
      this.username = localStorage.getItem("username");
      this.cx = localStorage.getItem("cx");
    }
    this.fetchCarouselData();
    console.log(this.$store.getters.getUser)
  },
  computed: {
    ...mapGetters(["getUser", "getNum"])
  },
  watch: {},
  methods: {
    fetchCarouselData() {
      this.$axios
          .get("/api/front/bianhuantu", {})
          .then(res => {
            let data = res.data.data;
            let filteredData = [];
            data.forEach(item => {
              filteredData.push(item);
            });
            this.carouselItems = filteredData;
          })
          .catch(err => {
            return Promise.reject(err);
          });
    },
    ...mapActions(["setUser", "setShowLogin", "setShoppingCart"]),
    login() {
      // 点击login按钮, 通过更改vuex的showLogin值显示login组件
      this.setShowLogin(true);
    },
    hsghoutai() {
      const w = window.open("about:blank");
      w.location.href = 'http://localhost:9999/#/';
    },
    // quit login
    logout() {
      this.visible = false;
      // 清空本地login信息
      localStorage.setItem("user", "");
      // 清空vuexlogin信息
      this.setUser("");
      this.notifySucceed("成功quit login");
    },
    // 接收enroll子组件传过来的数据
    isRegister(val) {
      this.register = val;
    },
  }
};
</script>

<style>
@import "assets/css/index2.css";
@import "assets/css/responsive.css";
@import "assets/css/bootstrap.css";
@import "assets/fonts/font-awesome/css/font-awesome.css";
@import "assets/css/owl.carousel.css";
@import "assets/css/owl.theme.css";
@import "assets/css/style.css";
@import "assets/css/prettyPhoto.css";
@import "assets/fonts/sns_fonts/iconfont.css";


/* 全局CSS */
* {
  padding: 0;
  margin: 0;
  /*border: 0;*/
  list-style: none;
  font-size: 14px;
}

.newsline TD {
  LINE-HEIGHT: 25px;
  BORDER-BOTTOM: #c9c9c9 1px dashed;
  text-align: left;
}

.newsline TD A:link {
  COLOR: #000
}

.newsline TD A:visited {
  COLOR: #000
}

.newsline TD A:hover {
  COLOR: #000
}

.newsline TD A:active {
  COLOR: #000
}

#app .el-header {
  padding: 0;
}

#app .el-main {
  min-height: 300px;
  padding: 20px 0;
}

#app .el-footer {
  padding: 0;
}

a,
a:hover {
  text-decoration: none;
}

/* 全局CSS END */

/* 顶部导航栏CSS */
.topbar {
  height: 40px;
  background-color: #3d3d3d;
  margin-bottom: 20px;
}

.topbar .nav {
  width: 1225px;
  margin: 0 auto;
}

.topbar .nav ul {
  float: right;
}

.topbar .nav li {
  float: left;
  height: 40px;
  color: #b0b0b0;
  font-size: 14px;
  text-align: center;
  line-height: 40px;
  margin-left: 20px;
}

.topbar .nav .sep {
  color: #b0b0b0;
  font-size: 12px;
  margin: 0 5px;
}

.topbar .nav li .el-button {
  color: #b0b0b0;
}

.topbar .nav .el-button:hover {
  color: #fff;
}

.topbar .nav li a {
  color: #b0b0b0;
}

.topbar .nav a:hover {
  color: #fff;
}


.topbar .nav .shopCart {
  width: 120px;
  background: #424242;
}

.topbar .nav .shopCart:hover {
  background: #fff;
}

.topbar .nav .shopCart:hover a {
  color: #ff6700;
}

.topbar .nav .shopCart-full {
  width: 120px;
  background: #ff6700;
}

.topbar .nav .shopCart-full a {
  color: white;
}

/* 顶部导航栏CSS END */

/* 顶栏容器CSS */
.el-header .el-menu {
  max-width: 1225px;
  margin: 0 auto;
  background-color: transparent;
}

.el-header .logo {
  /*height: 60px;*/
  width: 189px;
  float: left;
  margin-right: 100px;
}

.el-header .so {
  /*margin-top: 10px;*/
  width: 300px;
  float: right;
}

/* 顶栏容器CSS END */
.header {
  /*padding: 1em 0;*/
}

.w3layouts_logo {
  float: left;
}

.w3layouts_logo a {
  display: block;
  text-decoration: none;
}

h1, h2, h3, h4, h5, h6, a {
  font-family: 'Roboto Condensed', sans-serif;
  margin: 0;
}

.w3layouts_logo a h1 {
  padding-left: 20px;
  padding-top: 20px;
  font-size: 2.8em;
  color: #212121;
  text-transform: uppercase;

  padding-right: 1.67em;
  font-weight: 900;
  padding-bottom: 0.3em;
}

.w3layouts_logo a h1 span {

  color: #FF8D1B;
  font-size: .3em;
  display: block;
  font-weight: 300;
  letter-spacing: 5px;
  text-align: right;
  line-height: 0;
}

.w3_search input[type="text"] {
  outline: none;
  border: none;
  background: #EFEFEF;
  padding: 11px;
  text-align: center;
  font-size: 14px;
  color: #999;
  width: 71%;
  float: left;
  border-top-left-radius: 25px;
  border-bottom-left-radius: 25px;
}

.w3_search input[type="submit"] {
  outline: none;
  border: none;
  background: #212121;
  padding: 10px 0;
  font-size: 14px;
  color: #fff;
  width: 22%;
  border-top-right-radius: 25px;
  border-bottom-right-radius: 25px;
}

.w3l_sign_in_register {
  float: right;
  margin-top: 1em;
  width: 35%;
}

.w3l_sign_in_register ul li a {
  color: #fff;
  display: inline-block;
  text-transform: uppercase;
  text-decoration: none;
  background: #FF8D1B;
  text-align: center;
  padding: 6px 30px;
  font-weight: bold;
}

.fa-phone:before {
  content: "\f095";
}

.navbar-nav > li {
  float: left;
  border-right: 1px dotted #fff;
  width: 9%;
  text-align: center;
}

.navbar-default .navbar-nav > li > a {
  color: #fff;
  text-transform: uppercase;
}

.navbar-default .navbar-nav > li > a {
  color: #777;
}

.navbar-default .navbar-collapse, .navbar-default .navbar-form {
  border-color: #e7e7e7;
}

.navbar-nav > li > a {
  padding-top: 10px;
  padding-bottom: 10px;
  line-height: 20px;
}

.w1200 {
  overflow: visible;
  margin: 0 auto;
  width: 1200px;
  height: auto;
//overflow: hidden;
}

.nav > li {
  position: relative;
  display: block;
}

p, ul li, ol li {
  margin: 0;
  font-size: 14px;
}

article, aside, details, figcaption, figure, footer, header, hgroup, main, menu, nav, section, summary {
  display: block;
}

.movies_nav {


}

.w3l_sign_in_register ul li a {
  color: #fff;
  display: inline-block;
  text-transform: uppercase;
  text-decoration: none;
  background: #FF8D1B;
  text-align: center;
  padding: 6px 30px;
  font-weight: bold;
}

.owl-carousel {
  display: none;
  position: relative;
  width: 100%;
  -ms-touch-action: pan-y;
  background: #fff;
}

.img-responsive, .thumbnail > img, .thumbnail a > img, .carousel-inner > .item > img, .carousel-inner > .item > a > img {
  display: block;
  max-width: 100%;
}

.w3l-movie-gride-agile {
  text-align: center;
  box-shadow: 0px 0px 10px rgba(255, 255, 255, 0.35);
  margin-right: 0%;
  margin-bottom: 3%;
  position: relative;
  padding-left: 0;
}


.hvr-shutter-out-horizontal {
  display: inline-block;
  vertical-align: middle;
  -webkit-transform: translateZ(0);
  transform: translateZ(0);
  box-shadow: 0 0 1px rgba(0, 0, 0, 0);
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
  -moz-osx-font-smoothing: grayscale;
  position: relative;
  background: #e1e1e1;
  -webkit-transition-property: color;
  transition-property: color;
  -webkit-transition-duration: 0.3s;
  transition-duration: 0.3s;
}

.banner_1 {
  width: 100%;
  height: 100%;
//position: absolute; left: 0; top: 0;
}

</style>
