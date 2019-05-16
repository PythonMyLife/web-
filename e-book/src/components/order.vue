<template>
    <div class="manage">
        <div id="templatemo_container">
            <div id="templatemo_menu">
                <ul>
                    <li><a href="/index">退出登录</a></li>
                    <li><router-link :to="{name:'books',params:{username:this.username}}" >书籍浏览</router-link></li>
                    <li><router-link :to="{name:'manage',params:{username:this.username}}" >权限管理</router-link></li>
                    <li><router-link :to="{name:'order',params:{username:this.username}}" class="current" >订单管理</router-link></li>
                </ul>
            </div> <!-- end of menu -->

            <el-main style="width: 900px; margin: 0 auto;">
                <h2>订单：</h2>
                <el-table :data="items.filter(data => (!startdate || data.time >= startdate) &&(!enddate || data.time <= enddate))" :span-method="objectSpanMethod" border style="width: 100%; margin-top: 20px">
                    <el-table-column align="center" prop="order_id" label="订单号" width="100"></el-table-column>
                    <el-table-column align="center" prop="time" label="日期" width="160"></el-table-column>
                    <el-table-column align="center" prop="cover" label="封面" width="110">
                        <template slot-scope="scope">
                            <img :src="scope.row.cover" style="width: 80px; height: 120px">
                        </template>
                    </el-table-column>
                    <el-table-column align="center" prop="bookname" label="书名"></el-table-column>
                    <el-table-column align="center" prop="totalAmount" label="单价"></el-table-column>
                    <el-table-column align="center" prop="number" label="数量"></el-table-column>
                    <el-table-column align="center" prop="total" width="200">
                        <template slot="header" slot-scope="scope">
                            <el-input v-model="startdate" type="date" style="width: 170px;"/>
                            <el-input v-model="enddate"   type="date" style="width: 170px;"/>
                        </template>
                    </el-table-column>
                </el-table>
            </el-main>

        </div>
    </div>
</template>

<script>
    import axios from "axios";
    export default {
        name: 'manage',
        data() {
            return {
                username:'',
                items:[],
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
        },
        mounted () {
            this.username = this.$route.params.username;
            if (this.username === '') {
                alert("请登录后查看订单！");
                this.$router.push({name: "index"});
            }
            if(this.username == null){
                this.$alert("未登录请先登录");
                this.$router.push({name:"index",params:{}});
            }
            axios.get('http://localhost:8088/ebook/getOrders')
                .then(response => {
                    this.items = response.data;
                    for (let i = 0; i < this.items.length; i++) {
                        this.$set(this.items[i],'total',0);
                        if (i === 0) {
                            this.spanArr.push(1);
                            this.pos = 0;
                            this.items[i].total = this.items[i].totalAmount * this.items[i].number;
                        } else {
                            // 判断当前元素与上一个元素是否相同
                            if (this.items[i].order_id === this.items[i - 1].order_id) {
                                this.spanArr[this.pos] += 1;
                                this.spanArr.push(0);
                                this.items[this.pos].total += this.items[i].totalAmount * this.items[i].number;
                            } else {
                                this.spanArr.push(1);
                                this.pos = i;
                                this.items[this.pos].total = this.items[i].totalAmount * this.items[i].number;
                            }
                        }
                    }
                })
        }
    }
</script>
