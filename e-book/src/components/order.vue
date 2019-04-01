<template>
  <div class="manage">
    <div id="templatemo_container">
      <div id="templatemo_menu">
        <ul>
          <li><a href="/index">首页</a></li>
          <li><a href="/cart">购物车</a></li>
          <li><a href="/login">登录</a></li>
          <li><a href="/regist">注册</a></li>
          <li><a href="/manage">权限管理</a></li>
          <li><a href="/order" class="current">订单管理</a></li>
        </ul>
      </div> <!-- end of menu -->

      <el-table
              :data="tableData"
              style="width: 100%">
        <el-table-column
                prop="id"
                label="书名"
                width="180">
        </el-table-column>
        <el-table-column
                prop="nums"
                label="数量"
                width="180">
        </el-table-column>
        <el-table-column
                prop="price"
                label="价格">
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'manage',
  data() {
    return {
      tableData: [{
        id:'深入理解计算机系统',
        nums:2,
        price:198
      }, {
        id:'数据库系统导论',
        nums:1,
        price:200
      },{
        id:'中华人民共和国宪法',
        nums:1,
        price:50
      }]
    }
  }
}
</script>
