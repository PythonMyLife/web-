<template>
    <div class="index">
        <div id="templatemo_container">
            <div id="templatemo_menu">
                <ul>
                    <li><a href="/index">首页</a></li>
                    <li><a href="/books">书籍浏览</a></li>
                    <li><a href="/cart">购物车</a></li>
                    <li><a href="/regist">注册</a></li>
                    <li><a href="/userorder" class="current">订单与统计</a></li>
                </ul>
            </div> <!-- end of menu -->

            <el-main style="width: 800px; margin: 0 auto;">
                <el-card v-for="(order, orderIndex) in orders" :key="orderIndex" class="box-card" style="margin: 10px 0;">
                    <div slot="header" class="clearfix">
                        <span><b>{{ order.date }}</b> 订单号：{{ order.orderNumber }}</span>
                    </div>
                    <el-row style="text-align: center;">
                        <el-col :span="16">
                            <div v-for="(item, itemIndex) in order.items" :key="itemIndex" style="padding: 10px 0; border-bottom: 1px solid #eff2f6">
                                <el-row>
                                    <el-col :span="6">
                                        <img :src="item.cover" style="width: 100px;">
                                    </el-col>
                                    <el-col :span="6" style="line-height: 103.8px">
                                        {{ item.title }}
                                    </el-col>
                                    <el-col :span="6" style="height: 103.8px; display: flex; justify-content: center; flex-direction: column;">
                                        数量<br>{{ item.number }}
                                    </el-col>
                                    <el-col :span="6" style="height: 103.8px; display: flex; justify-content: center; flex-direction: column;">
                                        价格<br>{{ item.amount }}
                                    </el-col>
                                </el-row>
                            </div>
                        </el-col>
                        <el-col :span="4" style="height: 249.6px; display: flex; justify-content: center; flex-direction: column;">
                            总数<br>{{ order.number }}
                        </el-col>
                        <el-col :span="4" style="height: 249.6px; display: flex; justify-content: center; flex-direction: column;">
                            总价<br>{{ order.totalAmount }}
                        </el-col>
                    </el-row>
                </el-card>

                <h2>统计:</h2>
                <template>
                    <el-table
                            :data="tableData.filter(data => (!startdate || data.date >= startdate) &&(!enddate || data.date <= enddate))"
                            style="width: 100%">
                        <el-table-column
                                label="时间"
                                prop="date">
                        </el-table-column>
                        <el-table-column
                                label="书名"
                                prop="book">
                        </el-table-column>
                        <el-table-column
                                label="数量"
                                prop="num">
                        </el-table-column>
                        <el-table-column
                                label="总价"
                                prop="price">
                        </el-table-column>
                        <el-table-column
                                align="right">
                            <template slot="header" slot-scope="scope">
                                <el-input v-model="startdate" type="date" size="mini"/>
                                <el-input v-model="enddate"   type="date" size="mini"/>
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
    export default {
        name: "userorder",
        data: function () {
            return {
                startdate: '',
                enddate: '',
                activeIndex: 'orders',
                tableData: [
                    {
                        date: '2019-02-23 00:00:01',
                        book: '深入理解计算机系统',
                        num: 1,
                        price: 99
                    }, {
                        date: '2019-01-24 23:03:05',
                        book: '毛泽东语录',
                        num: 2,
                        price: 100
                    }
                ],
                orders: [
                    {
                        date: '2019-04-01',
                        orderNumber: 1651194849,
                        number: 2,
                        totalAmount: 200.00,
                        items: [{
                            cover: require('../assets/ics.jpg'),
                            title: '数据结构',
                            number: 1,
                            amount: '100.00'
                        }, {
                            cover: require('../assets/database.jpg'),
                            title: '软件工程原理',
                            number: 2,
                            amount: '100.00'
                        }]
                    }, {
                        date: '2019-04-01',
                        orderNumber: 1651195445,
                        number: 2,
                        totalAmount: 200.00,
                        items: [{
                            cover: require('../assets/database.jpg'),
                            title: '数据库系统概念',
                            number: 1,
                            amount: '100.00'
                        }, {
                            cover: require('../assets/ics.jpg'),
                            title: '深入理解计算机系统',
                            number: 2,
                            amount: '100.00'
                        }]
                    }]
            };
        }
    }
</script>

<style scoped>

</style>