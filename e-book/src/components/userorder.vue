<template>
    <div class="index">
        <div id="templatemo_container">
            <div id="templatemo_menu">
                <ul>
                    <li><a href="/index">退出登录</a></li>
                    <li><router-link :to="{name:'books',params:{username:this.username}}" >书籍浏览</router-link></li>
                    <li><router-link :to="{name:'cart',params:{username:this.username}}" >购物车</router-link></li>
                    <li><a href="#" class="current">订单与统计</a></li>
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
                <h2>统计:</h2>
                <template>
                    <el-table
                            :data="items.filter(data => (!starttime || data.time >= starttime) &&(!endtime || data.time <= endtime))"
                            style="width: 100%">
                        <el-table-column
                                label="时间"
                                prop="time">
                        </el-table-column>
                        <el-table-column
                                label="书名"
                                prop="bookname">
                        </el-table-column>
                        <el-table-column
                                label="数量"
                                prop="number">
                        </el-table-column>
                        <el-table-column style="width: 100px;"
                                         label="单价"
                                         prop="totalAmount">
                        </el-table-column>
                        <el-table-column
                                align="left">
                            <template slot="header" slot-scope="scope">
                                <el-input v-model="starttime" type="date" size="mini" style="width: 150px;"/>
                                <el-input v-model="endtime"   type="date" size="mini" style="width: 150px;"/>
                            </template>
                        </el-table-column>
                    </el-table>
                </template>

            </el-main>
            <div class="cleaner_with_height">&nbsp;</div>
        </div>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: 'orders',
        data: function () {
            return {
                username: '',
                activeIndex: 'orders',
                items: [],
                spanArr: [],
                startdate: '',
                enddate: '',
                starttime:'',
                endtime:''
            };
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
            let form = {"username": this.username};
            axios
                .post('http://localhost:8088/ebook/all_orders', form)
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
    };
</script>

<style scoped>

</style>