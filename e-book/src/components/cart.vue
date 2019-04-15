<template>
  <div class="home">
    <div id="templatemo_container">
      <div id="templatemo_menu">
        <ul>
          <li><a href="/index">首页</a></li>
          <li><a href="/books">书籍浏览</a></li>
          <li><a href="/cart" class="current">购物车</a></li>
          <li><a href="/regist">注册</a></li>
          <li><a href="/userorder">订单与统计</a></li>
        </ul>
      </div> <!-- end of menu -->

      <div id="templatemo_content" >
          <el-card class="box-card" style="text-align: center;">
            <div v-if="cartItems.length == 0">
              您的购物车为空
            </div>
            <el-row v-for="(item, index) in cartItems" :key="index" style="padding: 10px 0; border-bottom: 1px solid #eff2f6">
              <el-col :span="4" style="line-height: 103.8px">
                {{ item.title }}
              </el-col>
              <el-col :span="3" style="height: 104px; display: flex; justify-content: center; flex-direction: column;">
                单价：{{ item.price }}
              </el-col>
              <el-col :span="4" style="height: 104px; display: flex; justify-content: center; flex-direction: column;">
                数量：
                <el-input-number v-model="item.number" size="small" :min="1" :max="99"></el-input-number>
              </el-col>
              <el-col :span="3" style="height: 104px; display: flex; justify-content: center; flex-direction: column;">
                总价：{{ item.price * item.number }}
              </el-col>
              <el-col :span="3" style="height: 104px; display: flex; justify-content: center; flex-direction: column;">
                库存：{{ item.num }}
              </el-col>
              <el-col :span="5" style="line-height: 104px">
                <el-button  circle @click="handleDelete(item.id)">删除</el-button>
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
  export default {
    name: 'cart',
    data: function() {
      return {
        activeIndex: 'cart',
        cartItems: [{
          id: 1,
          title: '深入理解计算机系统',
          number: 1,
          num: 100,
          price: 99
        },{
          id: 2,
          title: '数据库系统原理',
          number: 2,
          num: 12,
          price: 139
        }]
      }
    },
    computed: {
      getTotalAmount() {
        var s = 0;
        for (var i = 0; i < this.cartItems.length; i++) {
          s += (this.cartItems[i].number * this.cartItems[i].price)
        }
        return s;
      }
    },
    methods: {
      handleDelete(id) {
        for (var i = 0; i < this.cartItems.length; i++)
        {
          if (this.cartItems[i].id == id) {
            this.cartItems.splice(i, 1);
          }
        }
      }
    }
  }
</script>
