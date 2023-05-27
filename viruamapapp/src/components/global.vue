<template>
    <div>
    <glomap :content="tableData"></glomap>
    <el-table :data="tableData" height="500"  border style="width: 100%">
    <el-table-column prop="location" label="国家/地区" ></el-table-column>
    <el-table-column prop="nowdia" label="现存确诊"> </el-table-column>
    <el-table-column prop="dia" label="确诊"> </el-table-column>
    <el-table-column prop="res" label="治愈"> </el-table-column>
    <el-table-column prop="de" label="死亡"> </el-table-column>
    </el-table>
    </div>
</template>

<script>
import axios from 'axios';
import glomap from "./glomap.vue"
export default {
    components: {
    glomap
  },
    name:'global',
    data(){
        return {
            tableData:[]
        }
    },
    created:function(){
        axios.get("/data").then((response)=>{
            this.tableData=response.data
        })
    }
}
</script>
