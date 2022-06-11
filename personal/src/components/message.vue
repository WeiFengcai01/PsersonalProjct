<template>
    <el-container>
        <el-header>
            <template>
                <el-row :gutter="20">
                    <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
                    <el-col :span="16">
                        <el-menu
                                :default-active="activeIndex"
                                class="el-menu-demo"
                                mode="horizontal" @select="handleSelect" router>
                            <template v-for="(item,index) in this.$router.options.routes" v-if="!item.hidden">
                                <el-menu-item :index="item.path" :key="item.path">{{item.name}}</el-menu-item>
                            </template>
                            <el-menu-item index="1">处理中心</el-menu-item>
                            <el-submenu index="2">
                                <template slot="title">我的工作台</template>
                                <el-menu-item index="2-1">选项1</el-menu-item>
                                <el-menu-item index="2-2">选项2</el-menu-item>
                                <el-menu-item index="2-3">选项3</el-menu-item>
                                <el-submenu index="2-4">
                                    <template slot="title">选项4</template>
                                    <el-menu-item index="2-4-1">选项1</el-menu-item>
                                    <el-menu-item index="2-4-2">选项2</el-menu-item>
                                    <el-menu-item index="2-4-3">选项3</el-menu-item>
                                </el-submenu>
                            </el-submenu>
                            <el-menu-item index="3" disabled>消息中心</el-menu-item>
                            <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>
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
        <el-container>
            <el-aside>aside</el-aside>
            <el-main>main</el-main>
        </el-container>
        <el-footer>footer</el-footer>
    </el-container>
</template>

<script>
    export default {
        name: "index",
        data() {
            return {
                activeIndex: '1',
                activeIndex2: '1'
            };
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            }
        }
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

    body > .el-container {
        margin-bottom: 40px;
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
    &:last-child {
         margin-bottom: 0;
     }
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
</style>