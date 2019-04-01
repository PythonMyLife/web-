<template>
  <div class="register">
    <div id="templatemo_container">
      <div id="templatemo_menu">
        <ul>
          <li><a href="/home" >首页</a></li>
          <li><a href="/cart">购物车</a></li>
          <li><a href="/login">登录</a></li>
          <li><a href="/regist" class="current">注册</a></li>
          <li><a href="/manage">权限管理</a></li>
          <li><a href="/order">订单管理</a></li>
        </ul>
      </div> <!-- end of menu -->

      <article >
        <section class="sign">
          <aside>
            <em>
              <img src="../assets/user.png">
            </em>
            <form action="#" method="post">
              <p class="name"><i></i><input type="text" id="userName" class="userName" placeholder="请输入用户名" value=""></p>
              <p class="password"><i></i><input type="password" id="password1" class="pwd" placeholder="请输入密码"></p>
              <p class="password"><i></i><input type="password" id="password2" class="pwd" placeholder="请再次输入密码"></p>
              <button>注册</button>
              <div class="clear"></div>
            </form>
          </aside>
        </section>
      </article>
      <div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of container -->
  </div>
</template>

<script>
export default {
  name: 'register',
  data: function() {
    return {

    }
  }
}
</script>
