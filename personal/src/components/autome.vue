<template>
    <el-container>
        <el-header class="header">
            <el-row>
                <el-col :span="1">
                    <div @click="drawer = true">
                        <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                    </div>
                </el-col>
                <el-col :span="23">
                    <el-aside>
                        <el-drawer
                                title="我是标题"
                                :visible.sync="drawer"
                                :direction="direction"
                                size="300px"
                        >
                            <span>我来啦!</span>
                        </el-drawer>
                    </el-aside>
                    <div>
                        <el-menu
                                :default-active="$route.path"
                                class="el-menu-demo"
                                mode="horizontal"
                                @select="handleSelect" router>
                            <template v-for="item in this.$router.options.routes" v-if="!item.hidden">
                                <el-menu-item :index="item.path" >{{item.name}}</el-menu-item>
                            </template>


                        </el-menu>
                    </div>
                </el-col>
            </el-row>


        </el-header>
        <el-container class="conter">

            <el-main>
                关于我

            </el-main>
            <el-footer>Footer</el-footer>

        </el-container>
    </el-container>
</template>

<script>
    export default {
        name: "home",
        data() {
            return {
                drawer: false,
                direction: 'ltr',
            };
        },

    }


</script>

<style scoped>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        line-height: 60px;
    }


    .el-main {
        background-color: #E9EEF3;
        color: #333;
    }

    .header{

    }
    .conter{
        height: 92vh;
    }
    .el-carousel__item h3 {
        color: #475669;
        font-size: 14px;
        opacity: 0.75;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    }


</style>