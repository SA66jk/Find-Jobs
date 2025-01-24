# <a href="https://gitee.com/lyt-top/vue-next-admin/tree/vue-prev-admin" target="_blank">vue-prev-admin update日志</a>

🎉🎉🔥 `vue-prev-admin` 基于 vue2.x + webpack + element ui，适配phone、平板、pc 的后台开源免费模板库（vue3.x 请切换 master 分支）

## 1.2.1

`2022.12.12`

- 🐞 优化 版本升级prompt
- 🐞 优化 深色模式

## 1.2.0

`2022.12.06`

- 🎉 新增 版本升级prompt
- 🎉 新增 主题色修改
- 🎉 新增 深色模式
- 🐞 优化 外链界面 `/src/layout/routerView/link.vue`
- 🐞 修复 `菜单水平折叠` 刷新界面还原默认值问题
- 💔 移除 `vue.config.js` 打包加时间戳方法，因为打包报错了

## 1.1.1

`2022.11.17`

- 🐞 优化 [vue2 版本打包出来配置路由懒加载无效。](https://gitee.com/lyt-top/vue-next-admin/issues/I5RFQT)，感谢[@林建生](https://gitee.com/ljsshuai)

## 1.1.0

`2022.06.12`

- 🐞 优化 部分界面演示format不出来问题
- 🐞 修复 [vue-prev-admin 全屏模式下，滚动条无法滚到底 #I4S79C](https://gitee.com/lyt-top/vue-next-admin/issues/I4S79C)，感谢[@qfvh](https://gitee.com/qfvh)

## 1.0.9

`2021.12.22`

- 🎯 优化 部署后每次都要强制刷新清浏览器缓存问题
- 🎉 新增 工具类百分比验证演示
- 🐞 修复 tag-view 标签右键会超出浏览器

## 1.0.8

`2021.12.16`

- 🌟 update 依赖update最新版本
- 🎯 优化 login界面逻辑、权限管理逻辑
- 🎯 优化 同步 vue-next-admin-images 后端控制菜单模拟数据
- 🎯 优化 菜单格式（对象改数组）
- 🐞 修复 login页phone端样式问题

## 1.0.7

`2021.11.27`

- 🌟 update 依赖update最新版本
- 🐞 修复 login问题 [#I4GIKU](https://gitee.com/lyt-top/vue-next-admin/issues/I4GIKU)

## 1.0.6

`2021.11.08`

- 🌟 update 依赖update最新版本
- 🎯 优化 目录移动 `@/views/layout` 移动 `@/layout` （可全局替换）
- 🎯 优化 eslint 语法检测问题，`@babel/eslint-parser` 替换已废弃的 `babel-eslint`，出现报错，请尝试降级 eslint
- 🎯 优化 vuex file自动Import

## 1.0.5

`2021.06.30`

- 🌟 update 依赖update最新版本
- 🎉 新增 表单自适应演示界面
- 🎯 优化 去掉内嵌 iframe 内边距（padding）

## 1.0.4

`2021.06.19`

- 🌟 update 依赖update最新版本
- 🎉 新增 项目仓库地址
- 🎯 优化 移除 utils/storage.ts 下的旧写法（改动较大）
- 🐞 修复 鼠标移入顶部Job Seekers信息栏 开/关全屏 文字反向问题

## 1.0.3

`2021.06.02`

- 🌟 update 依赖update最新版本
- 💯 优化 动态加载后端return路由路由(模拟数据)方法

## 1.0.2

`2021.06.01`

- 🐞 修复 菜单Search中文不可以Search的问题，感谢群友@逍遥天意

## 1.0.1

`2021.05.31`

- 🎉 新增 新增个人中心演示空白页
- 🎉 新增 update日志file `CHANGELOG.md`，以后每次update都会在这里显示对应content
- 🌟 update 依赖update最新版本
- 🐞 修复 分栏布局路由设置 `meta.isHide` 为 `true` 时报错问题，感谢群友@29、@芭芭拉
