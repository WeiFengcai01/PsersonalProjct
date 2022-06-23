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

                        <el-carousel :interval="2000" type="card" height="300px">
                            <el-carousel-item v-for="item in imgsrc" :key="item.id">
                                <img :src="'http://localhost:8181/'+item.src"
                                     height="659" width="941"/>
                            </el-carousel-item>
                        </el-carousel>
                <el-tabs >
                    <el-tab-pane>
                        <span slot="label"><i class="el-icon-s-custom"></i> 我的个人信息</span>
                        <el-descriptions class="margin-top" title="带边框列表" :column="3" :size="size" border style="height: 400px">
                            <template slot="title">
                                <el-row>
                                    <el-col :span="12">
                                        <el-avatar :size="70" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                                    </el-col>
                                    <el-col :span="12">66666</el-col>
                                </el-row>
                            </template>
                            <template slot="extra">
                                <el-button type="primary" size="small">操作</el-button>
                            </template>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-user"></i>
                                    用户名
                                </template>
                                kooriookami
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-mobile-phone"></i>
                                    手机号
                                </template>
                                18100000000
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-s-promotion"></i>
                                    邮箱
                                </template>
                                wfc666@163.com
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-user"></i>
                                    性别
                                </template>
                                男
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-s-custom"></i>
                                    学历
                                </template>
                                硕士
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-view"></i>
                                    星座
                                </template>
                                双子座
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-location-outline"></i>
                                    居住地
                                </template>
                                苏州市
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-location-outline"></i>
                                    居住地
                                </template>
                                苏州市
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-office-building"></i>
                                    联系地址
                                </template>
                                江苏省苏州市吴中区吴中大道 1188 号
                            </el-descriptions-item>           <el-descriptions-item>
                            <template slot="label">
                                <i class="el-icon-s-check"></i>
                                个人介绍
                            </template>
                            江苏省苏州市吴中区吴中大道 1188 号
                        </el-descriptions-item>
                        </el-descriptions>
                    </el-tab-pane>
                    <el-tab-pane label="日记">没有日记</el-tab-pane>
                    <el-tab-pane label="照片墙">
<!--                        <el-form>-->
<!--                        <el-upload-->
<!--                                class="upload-demo"-->
<!--                                drag-->
<!--                                action="http://localhost:8181/index/fileUpload"-->
<!--                                multiple>-->
<!--                            <i class="el-icon-upload"></i>-->
<!--                            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>-->
<!--                            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>-->
<!--                        </el-upload>-->

<!--                        </el-form>-->
                            <el-form>
                                <el-upload action="http://localhost:8181/index/fileUpload"
                                           list-type="picture-card" :auto-upload="true"
                                            :on-success="imgok"
                                            :before-upload="beforeAvatarUpload"
                                >
                                    <i slot="default" class="el-icon-plus"></i>
                                    <div slot="file" slot-scope="{file}">
                                        <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                                        <span class="el-upload-list__item-actions">
                                    <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)"><i class="el-icon-zoom-in"></i></span>
                                    <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleDownload(file)"><i class="el-icon-download"></i></span>
                                    <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemove(file)"><i class="el-icon-delete"></i></span>
                                </span>
                                    </div>
                                </el-upload>
                                <el-dialog :visible.sync="dialogVisible">
                                    <img width="100%" :src="dialogImageUrl" alt="">
                                </el-dialog>
                            </el-form>
                    </el-tab-pane>
                    <el-tab-pane label="无">
                        <el-row>
                            <el-col :span="8" v-for="(o, index) in 2" :key="o" :offset="index > 0 ? 2 : 0">
                                <el-card :body-style="{ padding: '0px' }" shadow="hover">
                                    <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
                                    <div style="padding: 14px;">
                                        <span>好吃的汉堡</span>
                                        <div class="bottom clearfix">
                                            <time class="time">{{ currentDate }}</time>
                                            <el-button type="text" class="button">操作按钮</el-button>
                                        </div>
                                    </div>
                                </el-card>
                            </el-col>
                        </el-row>
                    </el-tab-pane>
                </el-tabs>

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
                currentDate: new Date(),
                imgsrc:[],
                dialogImageUrl: '',
                dialogVisible: false,
                disabled: false

            };
        },
        methods: {
            handleRemove(file) {
                console.log(file);
            },
            handlePictureCardPreview(file) {
                this.dialogImageUrl = file.url;
                this.dialogVisible = true;
            },
            handleDownload(file) {
                console.log(file);
            },
            imgok(){
                alert("上传成功")
                location.reload();
            },
            beforeAvatarUpload(file) {

                const isLt2M = file.size / 1024 / 1024 < 5000;

                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isLt2M;
            }


        },
        created() {
            this.$ajax.get("index/imglist").then((res)=>{
                this.imgsrc=res.data
                // location.reload()
            })
        }


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