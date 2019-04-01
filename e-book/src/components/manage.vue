<template>
  <div class="manage">
    <div id="templatemo_container">
      <div id="templatemo_menu">
        <ul>
          <li><a href="/index">首页</a></li>
          <li><a href="/cart">购物车</a></li>
          <li><a href="/login">登录</a></li>
          <li><a href="/regist">注册</a></li>
          <li><a href="/manage" class="current">权限管理</a></li>
          <li><a href="/order">订单管理</a></li>
        </ul>
      </div> <!-- end of menu -->

      <template style="text-align: center">
        <el-table
                :data="tableData"
                style="width: 100%">
          <el-table-column
                  prop="username"
                  label="用户名"
                  width="180">
          </el-table-column>
          <el-table-column property="status" align="center" label="权限状态">
            <template slot-scope="scope">
              <el-switch active-color="#ff4949" inactive-color="#13ce66" v-model="scope.row.status" @change=change(scope.$index,scope.row)>
              </el-switch>
            </template>
          </el-table-column>
        </el-table>
      </template>
    </div>
  </div>
</template>

<script>
export default {
  name: 'manage',
  data() {
    return {
      tableData: [{
        index:1,
        username:'用户1'
      }, {
        index:2,
        username:'用户2'
      },{
        index:3,
        username:'用户3'
      },{
        index:3,
        username:'用户4'
      }]
    }
  }
}
</script>
