<template>
  <div class="home">
    <div id="templatemo_container">
      <div id="templatemo_menu">
        <ul>
          <li><a href="/index">首页</a></li>
          <li><router-link :to="{name:'books',params:{username:this.username}}" >书籍浏览</router-link></li>
          <li><a href="#" class="current">购物车</a></li>
          <li><a href="/regist">注册</a></li>
          <li><router-link :to="{name:'userorder',params:{username:this.username}}" >订单与统计</router-link></li>
        </ul>
      </div> <!-- end of menu -->

      <div id="templatemo_content" >
          <el-card class="box-card" style="text-align: center;">
            <div v-if="table.length == 0">
              您的购物车为空
            </div>
            <el-row v-for="(item, index) in table" :key="index" style="padding: 10px 0; border-bottom: 1px solid #eff2f6">
              <el-col :span="4" style="line-height: 103.8px">
                <img :src="item.cover" style="width: 70px">
              </el-col>
              <el-col :span="4" style="line-height: 103.8px">
                {{ item.title }}
              </el-col>
              <el-col :span="3" style="height: 104px; display: flex; justify-content: center; flex-direction: column;">
                单价：{{ item.price }}
              </el-col>
              <el-col :span="4" style="height: 104px; display: flex; justify-content: center; flex-direction: column;">
                数量：
                <el-input-number v-model="item.number" :precision="0" @change="handleChange(item.username,item.isbn,item.number)" size="small" :min="1" :max="99"></el-input-number>
              </el-col>
              <el-col :span="3" style="height: 104px; display: flex; justify-content: center; flex-direction: column;">
                总价：{{ item.price * item.number }}
              </el-col>
              <el-col :span="5" style="line-height: 104px">
                <el-button  circle @click="handleDelete(item.isbn)">删除</el-button>
              </el-col>
            </el-row>
          </el-card>
          <el-row style="margin-top: 10px;">
            <el-card class="box-card" style="text-align: center;">
              <el-row type="flex" justify="center">
                <el-col :span="4" style="text-align: center; line-height: 40px;">
                  总价: {{ getTotalAmount }}
                </el-col>
                <el-col :span="4" style="text-align: center;">
                  <el-button type="primary">下单</el-button>
                </el-col>
              </el-row>
            </el-card>
          </el-row>
      </div>
    </div> <!-- end of container -->
  </div>
</template>

<script>
  import axios from "axios";

  export default {
    name: 'cart',
    data: function() {
      return {
        username:'',
        table: [],
        activeIndex: 'cart',
        cartItems: [{
          id: 1,
          title: '深入理解计算机系统',
          number: 1,
          price: 99,
          cover:require("../../static/ics.jpg")
        },{
          id: 2,
          title: '数据库系统原理',
          number: 2,
          price: 139,
          cover:require("../../static/database.jpg")
        }]
      }
    },
    mounted () {
      this.username = this.$route.params.username;
      axios.get('http://localhost:8088/ebook/carts',{params:{username:this.username}}).then(response => {
        this.table = response.data;
      });
    },
    computed: {
      getTotalAmount() {
        var s = 0;
        for (var i = 0; i < this.table.length; i++) {
          s += (this.table[i].number * this.table[i].price)
        }
        return s;
      }
    },
    methods: {
      handleDelete(isbn) {
        for (var i = 0; i < this.table.length; i++)
        {
          if (this.table[i].isbn == isbn) {
            let form_data={"username":this.table[i].username,"ISBN":this.table[i].isbn};
            axios.post('http://localhost:8088/ebook/carts/handle_delete',form_data);
            this.table.splice(i, 1);
          }
        }
      },
      handleChange(username,isbn,number){
        let form_data={"username":username,"ISBN":isbn,"number":number};
        axios.post('http://localhost:8088/ebook/carts/change_book',form_data);
      }
    }
  }
</script>
