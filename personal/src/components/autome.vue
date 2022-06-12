<template>

    <div>
        <el-container>
            <el-header>
                <template>
                    <el-row :gutter="20">
                        <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
                        <el-col :span="16">
                            <el-menu
                                    :default-active="$route.path"
                                    class="el-menu-demo"
                                    mode="horizontal" @select="handleSelect" router>
                                <template v-for="(item,index) in this.$router.options.routes" v-if="!item.hidden">
                                    <el-menu-item :index="item.path" :key="item.path">{{item.name}}</el-menu-item>
                                </template>

                            </el-menu>






                        </el-col>
                        <el-col :span="4">

                            <div class="grid-content bg-purple">
                                <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                                <el-dropdown trigger="click" @command="handleCommand">
                                  <span class="el-dropdown-link">
                                    下拉菜单<i class="el-icon-arrow-down el-icon--right"></i>
                                  </span>
                                    <el-dropdown-menu slot="dropdown">
                                        <el-dropdown-item command="a">黄金糕</el-dropdown-item>
                                        <el-dropdown-item command="b">狮子头</el-dropdown-item>
                                        <el-dropdown-item command="c">螺蛳粉</el-dropdown-item>
                                        <el-dropdown-item command="d" disabled>双皮奶</el-dropdown-item>
                                        <el-dropdown-item command="e" divided>蚵仔煎</el-dropdown-item>
                                    </el-dropdown-menu>
                                </el-dropdown>
                            </div></el-col>
                    </el-row>
                </template>
            </el-header>

        </el-container>
        关于我
    </div>
</template>

<script>
    export default {
        name: "autome"
    }
</script>

<style scoped>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 160px;
    }
    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }
    .el-row {
        margin-bottom: 20px;
    }

    .el-col {
        border-radius: 4px;
    }
    .bg-purple-dark {
        background: #99a9bf;
    }
    .bg-purple {
        background: #d3dce6;
    }
    .bg-purple-light {
        background: #e5e9f2;
    }
    .grid-content {
        border-radius: 4px;
        min-height: 36px;
    }
    .row-bg {
        padding: 10px 0;
        background-color: #f9fafc;
    }
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 480px;
    }
    .content {
        min-height: calc(100vh - 140px);
    }
    .footer {
        height: 50px;
    }

</style>
