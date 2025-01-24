<template>
  <div>
    <el-form :inline="true" :model="formInline" class="user-search">
      <el-form-item label="">
        <el-input size="small" v-model="formInline.yonghuming" placeholder="Enter a username"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input size="small" v-model="formInline.xingming" placeholder="Enter a name"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button size="small" type="warning" icon="el-icon-search" @click="search">Search</el-button>
        <el-button size="small" type="primary" icon="el-icon-plus" @click="handleEdit()">Add</el-button>
        <el-button size="small" type="success" icon="el-icon-s-data" @click="daochu()"
                   v-if="userInfo.roles[0] == 'guanliyuan'">Export
        </el-button>
        <el-button size="small" type="danger" icon="el-icon-delete" @click="handleDeleteList()"
                   v-if="userInfo.roles[0] == 'guanliyuan'">Delete in bulk
        </el-button>

      </el-form-item>
      <el-form-item>
        <el-upload class="upload-demo" style="float: left; padding-right: 10px;"
                   action='http://localhost:9999/yonghuxinxi/upload' :headers='headers' :show-file-list='false'
                   :on-success='handleDaoruSuccess' :before-upload='beforeDaoruUpload'>
          <el-button size="small" type="info" icon="el-icon-sell" v-if="userInfo.roles[0] == 'guanliyuan'">Import
          </el-button>
        </el-upload>
      </el-form-item>
    </el-form>

    <el-table size="small" :data="listData" highlight-current-row v-loading="loading" border
              element-loading-text="Loading..." @selection-change="handleSelectionChange">
      <el-table-column align="center" type="selection" width="60"></el-table-column>
      <el-table-column sortable prop="yonghuming" label="Username"></el-table-column>
      <el-table-column sortable prop="xingming" label="name"></el-table-column>
      <el-table-column align="center" sortable prop="xingbie" label="gender" width="200px">
        <template slot-scope="scope">
          <el-switch v-model="scope.row.xingbie ? true : false" active-color="#13ce66" active-text="man"
                     inactive-text="woman" inactive-color="#ff4949"
                     @change="editxingbie(scope.$index, scope.row)"></el-switch>
        </template>
      </el-table-column>
      <el-table-column sortable prop="shouji" label="phone"></el-table-column>
      <el-table-column sortable prop="shenfenzheng" label="identity card"></el-table-column>
      <el-table-column align='center' prop='touxiang' label='avatar' width='120'>
        <template slot-scope='scope'>
          <el-image :src='scope.row.touxiang' style='height:70px' v-if="scope.row.touxiang"/>
          <img src="../../../static/images/guanli.jpg" style='height:70px' v-else/></template>
      </el-table-column>
      <el-table-column sortable prop="beizhu" label="comment"></el-table-column>

      <el-table-column sortable prop="addtime" label="Add Time" width="160">
        <template slot-scope="scope">
          <div>{{ scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss') }}</div>
        </template>
      </el-table-column>

      <el-table-column align="center" label="Operate" min-width="160">
        <template slot-scope="scope">

          <!--liangbuan-->
          <el-button size="mini" type="success" @click="handleEdit(scope.$index, scope.row)"
                     v-if="userInfo.roles[0] == 'guanliyuan' ">Edit
          </el-button>
          <el-button size="mini" type="danger" @click="deleteYonghuxinxi(scope.$index, scope.row)"
                     v-if="userInfo.roles[0] == 'guanliyuan' ">Delete
          </el-button>
          <el-button size='mini' type='primary' @click="handleDetail(scope.$index, scope.row)">Detailed</el-button>
          <!--zhixfuanniu-->

        </template>
      </el-table-column>
    </el-table>
    <Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>

    <el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
      <el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
        <el-form-item label="Username" prop="yonghuming">
          <el-input size="small" v-model="editForm.yonghuming" auto-complete="off" placeholder="Please enter a username"
                    style='width:50%'></el-input>
        </el-form-item>
        <el-form-item label="name" prop="xingming">
          <el-input size="small" v-model="editForm.xingming" auto-complete="off" placeholder="Please enter a name"
                    style='width:50%'></el-input>
        </el-form-item>
        <el-form-item label="gender" prop="xingbie" >
          <el-radio v-model="editForm.xingbie" :label=true>man</el-radio>
          <el-radio v-model="editForm.xingbie" :label=false>woman</el-radio>
        </el-form-item>

        <el-form-item label="phone" prop="shouji">
          <el-input size="small" v-model="editForm.shouji" auto-complete="off"
                    placeholder="Please enter your mobile phone" style='width:50%'></el-input>
        </el-form-item>
        <el-form-item label="identity card" prop="shenfenzheng">
          <el-input size="small" v-model="editForm.shenfenzheng" auto-complete="off" placeholder="Please enter your ID"
                    style='width:50%'></el-input>
        </el-form-item>
        <el-form-item label='avatar' prop='touxiang'>
          <el-upload class='avatar-uploader' action='http://localhost:9999/files/upload' :headers='headers'
                     :show-file-list='false' :on-success='handleTouxiangSuccess' :before-upload='beforeTouxiangUpload'>
            <img v-if='editForm.touxiang' :src='editForm.touxiang' class='avatar'><i v-else
                                                                                     class='el-icon-plus avatar-uploader-icon'></i>
          </el-upload>
        </el-form-item>
        <el-form-item label="comment" prop="beizhu">
          <el-input size="small" v-model="editForm.beizhu" auto-complete="off" placeholder="Please enter a comment"
                    style='width:50%'></el-input>
        </el-form-item>


      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="small" @click="closeDialog">Cancel</el-button>
        <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">Save
        </el-button>
      </div>
    </el-dialog>


    <!--xiangxidhk-->
    <!--zhixfudhk-->
  </div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import {
  yonghuxinxiList,
  yonghuxinxiSave,
  yonghuxinxiDelete,
  yonghuxinxiEdit,
  yonghuxinxiDeleteList
} from '@/api/yonghuxinxi/yonghuxinxiApi';


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
      //detaitFormVsisisble


      editForm: {},
      user: [],
      username: '',
      cx: '',

      rules: {
        yonghuming: [{required: true, message: 'Please enter a username', trigger: 'blur'},
        ],
        xingming: [{required: true, message: 'Please enter a name', trigger: 'blur'},
        ],
        shenfenzheng: [{
          pattern: /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/,
          required: true,
          message: 'Please enter the correct ID number',
          trigger: 'blur'
        }
        ],

      },

      formInline: {
        page: 1,
        limit: 10,
      },


      listData: [],
      yonghuxinxis: [],

      checkmenu: [],
      pageparm: {
        currentPage: 1,
        pageSize: 10,
        total: 0
      }
    };
  },
  computed: {
    headers() {
      return {"token": Session.get("token")}
    }
  },
  watch: {
    '$route'(to, from) {
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
    this.username = localStorage.getItem("username");
    this.cx = localStorage.getItem("cx");

    this.getdata(this.formInline)

  },
  methods: {

    //zxhifuff
    handleShenheList() {
      const yonghuxinxis = this.yonghuxinxis;
      if (yonghuxinxis.length == 0) {
        this.$message({
          type: 'error',
          message: 'Please select at least one'
        })
      } else {
        this.$confirm('Are you sure you want to review in bulk?', 'Info', {
          confirmButtonText: 'sure',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
          yonghuxinxis.forEach(item => {
            let data = {...item, issh: 1}
            yonghuxinxiEdit(data).then(res => {
            })
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
      yonghuxinxiList(parameter)
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
        this.title = 'Edit candidate information'
        this.editForm = row
      } else {
        this.title = 'AddJob Seeker Information'
        this.editForm = {}


        //zixdonxgbianxhao1
      }
    },
    daochu() {
      axios.get('/yonghuxinxi/getExcel', {
        responseType: 'blob',
        headers: {token: Session.get("token"), 'Content-Type': 'application/x-download'}
      }).then((res) => {
        if (res.status === 200) {
          var a = document.createElement('a')
          var blob = new Blob([res.data], {type: 'application/vnd.ms-excel'})
          var href = window.URL.createObjectURL(blob)
          a.href = href
          a.download = 'Job Seekers信息.xlsx'
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
      if (res.code == "0") {
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

    handleDetail(index, row) {
      const w = window.open("about:blank");
      w.location.href = 'http://localhost:8080/#/yonghuxinxidetail/' + row.id;
    },
    //liangbuedit
    // Edit、增加页面Save方法
    submitForm(editData) {

      this.$refs[editData].validate(valid => {
        if (valid) {
          if (this.editForm.id) {
            yonghuxinxiEdit(this.editForm).then(res => {
              this.editFormVisible = false

              this.loading = false
              if (res.code == '0') {
                this.getdata(this.formInline)
                this.$message({
                  type: 'success',
                  message: 'Job Seekers信息修改成功！'
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
              if (err) {
                this.$message.error(err)
              } else {
                this.$message.error('Operate失败，请稍后再试！')
              }
            })
          } else {
            yonghuxinxiSave(this.editForm).then(res => {
              this.editFormVisible = false
              this.loading = false
              if (res.code == '0') {

                this.getdata(this.formInline)
                this.$message({
                  type: 'success',
                  message: 'Job Seeker Information Add successfully！'
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
              if (err) {
                this.$message.error(err)
              } else {
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
    deleteYonghuxinxi(index, row) {
      this.$confirm('Are you sure you want to delete?', 'Info', {
        confirmButtonText: 'sure',
        cancelButtonText: 'Cancel',
        type: 'warning'
      }).then(() => {
        yonghuxinxiDelete(row.id).then(res => {
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
    handleSelectionChange(val) {
      this.yonghuxinxis = val;
    },
    handleDeleteList() {
      const yonghuxinxis = this.yonghuxinxis;
      if (yonghuxinxis.length == 0) {
        this.$message({
          type: 'error',
          message: 'Please select at least one item to delete'
        })
      } else {
        this.$confirm('Are you sure you want to delete in bulk?', 'Info', {
          confirmButtonText: 'sure',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
          yonghuxinxiDeleteList(yonghuxinxis).then(res => {
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
    editxingbie(index, row) {
      let data = {...row, xingbie: !row.xingbie}
      yonghuxinxiEdit(data).then(res => {
        this.editFormVisible = false
        this.loading = false
        if (res.code == '0') {
          this.getdata(this.formInline)
          this.$message({
            type: 'success',
            message: 'Gender modification is successful\n！'
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
        if (err) {
          this.$message.error(err)
        } else {
          this.$message.error('Operate失败，请稍后再试！')
        }
      })
    },
    //xuaxnzeshxifou


    handleTouxiangSuccess(res, file) {
      if (res.code == "0") {
        this.editForm.touxiang = "/files/download/" + res.data.id
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
