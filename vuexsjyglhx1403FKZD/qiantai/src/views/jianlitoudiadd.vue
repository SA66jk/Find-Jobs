<template>
  <div id="details">
    <!-- 头部 -->
    <div class="page-header">
      <div class="title" style="font-size: 14px;">
        <p>Home>> Resume delivery list >> Resume delivery Add </p>
      </div>
    </div>
    <div class="main">
      <div class="content">
        <el-form label-width="150px" ref="editForm" :model="editForm" :rules="rules">
          <el-form-item  label="Job Title" prop="gangweimingcheng"><el-input size="small" v-model="editForm.gangweimingcheng" auto-complete="off" placeholder="Please enter a Job Title" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="working hours" prop="gongzuoshijian"><el-input size="small" v-model="editForm.gongzuoshijian" auto-complete="off" placeholder="Please enter your working hours" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="Enterprise number" prop="qiyehao"><el-input size="small" v-model="editForm.qiyehao" auto-complete="off" placeholder="请Enter your enterprise number" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="The name of the business" prop="qiyemingcheng"><el-input size="small" v-model="editForm.qiyemingcheng" auto-complete="off" placeholder="Please enter the account numberThe name of the business" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="Head" prop="fuzeren"><el-input size="small" v-model="editForm.fuzeren" auto-complete="off" placeholder="Please enter the person in charge" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="Username" prop="yonghuming"><el-input size="small" v-model="editForm.yonghuming" auto-complete="off" placeholder="Please enter a username" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="name" prop="xingming"><el-input size="small" v-model="editForm.xingming" auto-complete="off" placeholder="Please enter a name" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="phone" prop="shouji"><el-input size="small" v-model="editForm.shouji" auto-complete="off" placeholder="Please enter your mobile phone" style='width:50%'></el-input></el-form-item>
		<el-form-item  label='Curriculum vitae documents' prop='jianliwenjian'><el-upload class='avatar-uploader' action='/api/files/front/uploadwenjian' :headers='headers' :show-file-list='false' :on-success='handleJianliwenjianSuccess' ><el-button>upload</el-button></el-upload></el-form-item>
		

        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">Add</el-button>
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
		username:'',
        cx:'',
		//xiabiaoduan2
		gangweixinxiID:'',
gangweixinxi:'',

        rules: {
          
        },
        editForm: {
          avater:'',
          gangweimingcheng:'',
gongzuoshijian:'',
qiyehao:'',
qiyemingcheng:'',
fuzeren:'',


        },
      };
    },
    watch: {
      '$route' (to, from) {
        // 路由发生变化页面刷新
        this.$router.go(0);
      }
    },
    created() {
      if (localStorage.getItem("user")) {
            // 如果已经login，设置vuexlogin状态
            //this.setUser(JSON.parse(localStorage.getItem("user")));
			this.userInfo=JSON.parse(localStorage.getItem("user"));
            this.username = localStorage.getItem("username");
            this.cx = localStorage.getItem("cx");
        }
		this.editForm.yonghuming= this.username;
		//xiabiaoduan3
	  this.editForm.xingming= this.userInfo.xingming;
				this.editForm.shouji= this.userInfo.shouji;
				
	  
	  let id = this.$route.params.id;this.getDetails(id);
    },
    methods: {
	//xiabiaoduan4
	//xia2sui1
      getProjectNum () {
        const projectTime = new Date() // 当前中国标准时间
        const Year = projectTime.getFullYear() // 获取当前年份 支持IE和火狐浏览器.
        const Month = projectTime.getMonth() + 1 // 获取中国区月份
        const Day = projectTime.getDate() // 获取几号
        var CurrentDate = Year
        if (Month >= 10) { // 判断月份和几号是否大于10或者小于10
          CurrentDate += Month
        } else {
          CurrentDate += '0' + Month
        }
        if (Day >= 10) {
          CurrentDate += Day
        } else {
          CurrentDate += '0' + Day
        }
        return CurrentDate
      },
	  //qixuzhijixsuan3
	  getDetails(id){
			this.$axios
                .get("/api/front/getgangweixinxidetail/"+id,)
                .then(res => {
                  this.gangweixinxi = res.data.data;
                  this.editForm.gangweimingcheng = this.gangweixinxi.gangweimingcheng;
					this.editForm.gongzuoshijian = this.gangweixinxi.gongzuoshijian;
					this.editForm.qiyehao = this.gangweixinxi.qiyehao;
					this.editForm.qiyemingcheng = this.gangweixinxi.qiyemingcheng;
					this.editForm.fuzeren = this.gangweixinxi.fuzeren;
				
                  this.editForm.yonghuming= this.username;
                })
                .catch(err => {
                  return Promise.reject(err);
                });
			
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
				
      submitForm(editData) {
        this.$refs[editData].validate(valid => {
          if (valid) {
            if(this.editForm.id){
            }else {
              this.$axios
                      .post("/api/front/postjianlitoudi/",this.editForm)
                      .then(res => {
                        if (res.data.code == '0') {
						//kuabiaogaizhi1
                          this.$message({
                            type: 'success',
                            message: 'Add success！'
                          })
                        }
						
						else {
                          this.$message({
                            type: 'info',
                            message: res.msg
                          })
                        }
                      }).catch(err => {
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
    height: 560px;
    padding-top: 30px;
    margin: 0 auto;
  }
  #details .main .block {
    float: left;
    width: 560px;
    height: 560px;
  }
  #details .el-carousel .el-carousel__indicator .el-carousel__button {
    background-color: rgba(163, 163, 163, 0.8);
  }
  #details .main .content {
    float: left;
    margin-left: 25px;
    width: 640px;
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
    width: 340px;
    background-color: #ff6700;
  }
  #details .main .content .button .shop-cart:hover {
    background-color: #f25807;
  }

  #details .main .content .button .like {
    width: 260px;
    margin-left: 40px;
    background-color: #b0b0b0;
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
