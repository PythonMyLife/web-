<template>
    <div class="books">
        <div id="templatemo_container">
            <div id="templatemo_menu">
                <ul>
                    <li><a href="/index">首页</a></li>
                    <li><a href="/books" class="current">书籍浏览</a></li>
                    <li><a href="/cart">购物车</a></li>
                    <li><a href="/regist">注册</a></li>
                    <li><a href="/userorder">订单与统计</a></li>
                </ul>
            </div> <!-- end of menu -->

            <div id="templatemo_header"></div> <!-- end of header -->
                <el-table
                        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                        style="width: 100%">
                    <el-table-column label="书名" prop="name"></el-table-column>
                    <el-table-column label="作者" prop="author"></el-table-column>
                    <el-table-column label="封面" prop="cover" align="center">
                        <template slot-scope="scope">
                            <img :src="scope.row.cover" style="width: 70px">
                        </template>
                    </el-table-column>
                    <el-table-column label="ISBN编号" prop="ISBN"></el-table-column>
                    <el-table-column label="库存量" prop="num"></el-table-column>
                    <el-table-column align="right">
                        <template slot="header" slot-scope="scope">
                            <el-input v-model="search" size="mini" placeholder="输入关键字搜索"/>
                        </template>
                        <template slot-scope="scope">
                            <el-button size="mini" @click="handledetail(scope.$index, scope.row)">详情</el-button>
                            <el-button size="mini" type="danger" @click="handleadd(scope.$index, scope.row)">加购</el-button>
                        </template>
                    </el-table-column>
                </el-table>

            <div class="cleaner_with_height">&nbsp;</div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'books',
        data: function() {
            return {
                tableData: [{
                    ISBN: '9787111544937',
                    name: '深入理解计算机系统',
                    author: '小兰兰',
                    cover: require('../assets/ics.jpg'),
                    num: 100
                }, {
                    ISBN: '9787302259459',
                    name: '数据结构',
                    author: '小兰兰',
                    cover: require('../assets/ics.jpg'),
                    num: 100
                }, {
                    ISBN: '9787111544937',
                    name: '数据库系统概念',
                    author: '小兰兰',
                    cover: require('../assets/ics.jpg'),
                    num: 100
                }, {
                    ISBN: '9787111544937',
                    name: '软件工程导论',
                    author: '小兰兰',
                    cover: require('../assets/ics.jpg'),
                    num: 100
                }],
                search: ''
            }
        },
        methods: {
            handledetail(index, row) {
                this.$router.push('/subpage');
            },
            handleadd(index, row) {
                this.$alert(row);
            }
        },
    }
</script>

<style scoped>

</style>