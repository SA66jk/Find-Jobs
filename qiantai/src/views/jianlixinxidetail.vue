<template>
  <div id="details">
    <!-- 头部 -->
    <div class="page-header">
      <div class="title" style="font-size: 14px;">
        <p>Home>> A list of resume information >> Resume information is detailed </p>
      </div>
    </div>
    <div class="main">
		<el-card  shadow="hover" style="width: 560px; float:left">
			<div class="block">
				<div>
					<img style="height:500px;width: 500px" :src="`/api/`+jianlixinxidetail.zhaopian" />
				</div>
			</div>
		</el-card>
      <div class="content">
  <table width="100%" border="0"  align="center" cellpadding="3" cellspacing="1" class="newsline">
								<tr>
        <td width='22%' height=44>Resume number：</td><td width='39%' >{{jianlixinxidetail.jianlibianhao}}</td></tr><tr>
         <td width='22%' height=44>name：</td><td width='39%' >{{jianlixinxidetail.xingming}}</td></tr><tr>
         <td width='22%' height=44>gender：</td><td width='39%'><div v-if="jianlixinxidetail.xingbie==1">man</div><div v-else>woman</div></td></tr><tr>
         <td width='22%' height=44>phone：</td><td width='39%' >{{jianlixinxidetail.shouji}}</td></tr><tr>
         <td width='22%' height=44>specialized：</td><td width='39%' >{{jianlixinxidetail.zhuanye}}</td></tr><tr>
         
         
         <td width='22%' height=44>Username：</td><td width='39%' >{{jianlixinxidetail.yonghuming}}</td></tr><tr>
         <td width='22%' height=44>file：</td><td width='39%'><el-button size='small' @click="download(jianlixinxidetail.wenjian)">Download</el-button></td></tr><tr>
         <td width='22%' height=100  >Biography：</td><td width='39%' colspan=2 height=100 ><div v-html="jianlixinxidetail.gerenjianjie" ></div></td></tr>
</table>
        <div class="button">
		  <!--dshoucang1-->
		  
		  
        </div>
      </div>
	  
    </div>
  </div>
</template>
<script>

  export default {
    data() {
      return {
        dis: false, // 控制“加入购物车按钮是否可用”
        jianlixinxiID:'',
        jianlixinxidetail: "", // 商品Detailed信息
		
      };
    },
    watch: {
      '$route' (to, from) {
        // 路由发生变化页面刷新
        this.$router.go(0);
      }
    },
    created() {
      this.jianlixinxiID= this.$route.params.id;
      let id = this.$route.params.id;
      this.id = id;
      this.getDetails(id);
	  
    },
    methods: {
		
      download(xx){location.href = "http://localhost:9999/"+xx;},
      getDetails(val) {
        this.$axios
                .get("/api/front/getjianlixinxidetail/"+val,)
                .then(res => {
                  debugger
                  this.jianlixinxidetail = res.data.data;
                })
                .catch(err => {
                  return Promise.reject(err);
                });
      },
     
		
        addCollect() {
        if (!this.$store.getters.getUser) {
          this.$store.dispatch("setShowLogin", true);
          return;
        }
        
        this.$axios
                .post("/api/front/addCollect", {
                  userId: this.$store.getters.getUser.id,
                  shangpinxinxiID: this.jianlixinxiID
                })
                .then(res => {
                  if (res.data.code == "0") {
                    this.notifySucceed(res.data.msg);
                  } else {
                    this.notifyError(res.data.msg);
                  }
                })
                .catch(err => {
                  return Promise.reject(err);
                });
      }
    }
  };
</script>
<style>
    @import "../assets/css/index.scss";
    /* 头部CSS */
    #details .page-header {
        height: 64px;
        margin-top: -20px;
        z-index: 4;
        background: #fff;
        border-bottom: 1px solid #e0e0e0;
        -webkit-box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
        box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
    }
    #details .page-header .title {
        width: 1225px;
        height: 64px;
        line-height: 64px;
        font-size: 18px;
        font-weight: 400;
        color: #212121;
        margin: 0 auto;
    }
    #details .page-header .title p {
        float: left;
    }
    #details .page-header .title .list {
        height: 64px;
        float: right;
    }
    #details .page-header .title .list li {
        float: left;
        margin-left: 20px;
    }
    #details .page-header .title .list li a {
        font-size: 14px;
        color: #616161;
    }
    #details .page-header .title .list li a:hover {
        font-size: 14px;
        color: #ff6700;
    }
    /* 头部CSS END */

    /* 主要contentCSS */
    #details .main {
        width: 1225px;
        padding-top: 30px;
        margin: 0 auto;
    }
    #details .main .block {
        float: left;
        width: 520px;
        height: 520px;
        padding-right: 20px;
    }
    #details .main .block:hover {
        transform: scale(0.9);
        -ms-transform: scale(0.9);
    }
    #details .el-carousel .el-carousel__indicator .el-carousel__button {
        background-color: rgba(163, 163, 163, 0.8);
    }
    #details .main .content {
        float: left;
        margin-left: 25px;
        width: 50%;
    }
    #details .main .content .name {
        height: 30px;
        line-height: 30px;
        font-size: 24px;
        font-weight: normal;
        color: #212121;
    }
    #details .main .content .intro {
        color: #b0b0b0;
        padding-top: 10px;
    }
    #details .main .content .store {
        color: #ff6700;
        padding-top: 10px;
    }
    #details .main .content .price {
        display: block;
        font-size: 18px;
        color: #ff6700;
        border-bottom: 1px solid #e0e0e0;
        padding: 25px 0 25px;
    }
    #details .main .content .price .del {
        font-size: 14px;
        margin-left: 10px;
        color: #b0b0b0;
        text-decoration: line-through;
    }
    #details .main .content .pro-list {
        background: #f9f9fa;
        padding: 30px 60px;
        margin: 50px 0 50px;
    }
    #details .main .content .pro-list span {
        line-height: 30px;
        color: #616161;
    }
    #details .main .content .pro-list .pro-price {
        float: right;
    }
    #details .main .content .pro-list .pro-price .pro-del {
        margin-left: 10px;
        text-decoration: line-through;
    }
    #details .main .content .pro-list .price-sum {
        color: #ff6700;
        font-size: 24px;
        padding-top: 20px;
    }
    #details .main .content .button {
        height: 55px;
        margin: 10px 0 20px 0;
    }
    #details .main .content .button .el-button {

        float: left;
        height: 55px;
        font-size: 16px;
        color: #fff;
        border: none;
        text-align: center;
    }
    #details .main .content .button .shop-cart {
        width: 140px;
        background-color: #ff6700;
    }
    #details .main .content .button .shop-cart:hover {
        background-color: #f25807;
    }
	#details .main .content .button .hsg1 {
        width: 140px;
        background-color: #4ba3ff;
    }
    #details .main .content .button .hsg1:hover {
        background-color: #4561ff;
    }

    #details .main .content .button .like {
        width: 140px;
       
        background-color: #46b273;
    }
    #details .main .content .button .like:hover {
        background-color: #757575;
    }
    #details .main .content .pro-policy li {
        float: left;
        margin-right: 20px;
        color: #b0b0b0;
    }
    /* 主要contentCSS END */
</style>
