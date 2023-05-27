<template>
  <div id="app">
    <h1>新型冠状病毒（SARS-COV-19）疫情地图</h1>
    <h3>截至2021年1月8日10时02分数据统计</h3>
    <global></global>
  </div>
</template>

<script>
import global from "./components/global.vue"
import glomap from "./components/glomap.vue"
export default {
  name: 'App',
  components: {
    global,
    glomap
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
