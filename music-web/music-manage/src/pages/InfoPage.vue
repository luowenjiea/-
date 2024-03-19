<template>
  <div align="center" style="font-size:19px;margin-top:30px;">
    欢迎来到在线音乐网站后台管理系统
  </div>
</template>

<script>
import { mixin } from '../mixins'

export default {
  mixins: [mixin],
  data () {
    return {
      user: []
    }
  },
  mounted () {
  },
  methods: {

  }
}
</script>

<style>
  .grid-content {
    display: flex;
    align-items: center;
    height: 100px;
  }

  .grid-cont-right {
    flex: 1;
    text-align: center;
    font-size: 14px;
    color: #999;
  }

  .grid-num {
    font-size: 30px;
    font-weight: bold;
  }

  .cav-info {
    border-radius: 6px;
    overflow: hidden;
  }
</style>
