
<template>
    <div style="height:500px;width:100%" id="charts"></div>
</template>

<script>
const axios = require('axios');

import world from '../map/js/world'
import jsonp from "jsonp";

let option = {
  title: {
    text: "疫情地图", //图表 标题
    x: "center",
    textStyle: {
      color: "red"
    }
  },
  toolbox: {
    //工具栏
    feature: {
      saveAsImage: {} //保存图片
    }
  },
  tooltip: {
    //提示信息
    trigger: "item", //类型
    formatter: "地图：{b}<br/>确诊：{c}"
  },
  series: [
    //数据
    {
      title:{text:'确诊'},
      type: "map", //图表类型 是地图
      map: "china", //中国地图
      zoom: 1.2, //缩放比例
      roam: true,
      data: [],
      label: {
        //图形上的文本标签，可用于说明图形的一些数据信息
        show: true,
        color: "#eee",
        fontSize: 10
      },
      emphasis: {
        //输入表移入的显示情况
        label: {
          //图形上的文本标签，可用于说明图形的一些数据信息
          show: true,
          color: "#ffffff", //鼠标移入文字颜色
          fontSize: 16
        },
        itemStyle: {
          show: true,
          areaColor: "#ccc" //鼠标移入背景颜色
        }
      },
      itemStyle: {
        backgroundColor: "red",
        borderColor: "#eee",
        borderWidth: 1,
        borderType: "solid",
        areaColor: "#ccc"
      }
    }
  ],

  visualMap: {
    //视觉映射组件 --侧边柱子
    type: "piecewise", //piecewise 点状视觉映射组件，continuous 直线状视觉映射组件
    // min: 8, //最低多少
    // max: 500, //最高多少
    // text: ["High", "Low"], //高低处文本
    // realtime: true, // 拖拽时，是否实时更新
    // calculable: true, //是否显示拖拽用的手柄（手柄能拖拽调整选中范围）
    itemWidth: 10, //每个方块的宽度
    itemHeight: 20, //每个方块的高度
    inRange: {
      //范围
      color: ["#d0ddec", "#42b983", "red"] //高中低处的颜色
    },
    pieces: [
      { min: 400 }, // 不指定 max，表示 max 为无限大（Infinity）。
      { min: 80, max: 300 },
      { min: 60, max: 79 },
      { min: 20, max: 59 },
      { min: 1, max: 19 },
      // { value: 123, label: "123（自定义特殊颜色）", color: "grey" },  // 表示 value 等于 123 的情况。
      { value: 0 }
    ]
  }
};
export default {
  props: ["content"],
    name:'glomap',
   data(){
    return {
      value: "world",
      myChart:null,
    //   注册地图json
       jsonMap: {
        'world':world,
        },
        // 全球数据
// 全球地域中文映射
nameMap : {
  "Afghanistan": "阿富汗",
                            "Albania": "阿尔巴尼亚",
                            "Algeria": "阿尔及利亚",
                            "Angola": "安哥拉",
                            "Argentina": "阿根廷",
                            "Armenia": "亚美尼亚",
                            "Australia": "澳大利亚",
                            "Austria": "奥地利",
                            "Azerbaijan": "阿塞拜疆",
                            "Bahamas": "巴哈马",
                            "Bahrain": "巴林",
                            "Bangladesh": "孟加拉国",
                            "Belarus": "白俄罗斯",
                            "Belgium": "比利时",
                            "Belize": "伯利兹",
                            "Benin": "贝宁",
                            "Bhutan": "不丹",
                            "Bolivia": "玻利维亚",
                            "Bosnia and Herz.": "波斯尼亚和黑塞哥维那",
                            "Botswana": "博茨瓦纳",
                            "Brazil": "巴西",
                            "British Virgin Islands": "英属维京群岛",
                            "Brunei": "文莱",
                            "Bulgaria": "保加利亚",
                            "Burkina Faso": "布基纳法索",
                            "Burundi": "布隆迪",
                            "Cambodia": "柬埔寨",
                            "Cameroon": "喀麦隆",
                            "Canada": "加拿大",
                            "Cape Verde": "佛得角",
                            "Cayman Islands": "开曼群岛",
                            "Central African Rep.": "中非共和国",
                            "Chad": "乍得",
                            "Chile": "智利",
                            "China": "中国",
                            "Colombia": "哥伦比亚",
                            "Comoros": "科摩罗",
                            "Congo": "刚果（布）",
                            "Costa Rica": "哥斯达黎加",
                            "Croatia": "克罗地亚",
                            "Cuba": "古巴",
                            "Cyprus": "塞浦路斯",
                            "Czech Rep.": "捷克",
                            "Côte d'Ivoire": "科特迪瓦",
                            "Dem. Rep. Congo": "刚果（金）",
                            "Dem. Rep. Korea": "朝鲜",
                            "Denmark": "丹麦",
                            "Djibouti": "吉布提",
                            "Dominican Rep.": "多米尼加",
                            "Ecuador": "厄瓜多尔",
                            "Egypt": "埃及",
                            "El Salvador": "萨尔瓦多",
                            "Equatorial Guinea": "赤道几内亚",
                            "Eritrea": "厄立特里亚",
                            "Estonia": "爱沙尼亚",
                            "Ethiopia": "埃塞俄比亚",
                            "Falkland Is.": "福克兰群岛",
                            "Fiji": "斐济",
                            "Finland": "芬兰",
                            "Fr. S. Antarctic Lands": "所罗门群岛",
                            "France": "法国",
                            "Gabon": "加蓬",
                            "Gambia": "冈比亚",
                            "Georgia": "格鲁吉亚",
                            "Germany": "德国",
                            "Ghana": "加纳",
                            "Greece": "希腊",
                            "Greenland": "格陵兰",
                            "Guatemala": "危地马拉",
                            "Guinea": "几内亚",
                            "Guinea-Bissau": "几内亚比绍",
                            "Guyana": "圭亚那",
                            "Haiti": "海地",
                            "Honduras": "洪都拉斯",
                            "Hungary": "匈牙利",
                            "Iceland": "冰岛",
                            "India": "印度",
                            "Indonesia": "印度尼西亚",
                            "Iran": "伊朗",
                            "Iraq": "伊拉克",
                            "Ireland": "爱尔兰",
                            "Isle of Man": "马恩岛",
                            "Israel": "以色列",
                            "Italy": "意大利",
                            "Jamaica": "牙买加",
                            "Japan": "日本",
                            "Jordan": "约旦",
                            "Kazakhstan": "哈萨克斯坦",
                            "Kenya": "肯尼亚",
                            "Korea": "韩国",
                            "Kuwait": "科威特",
                            "Kyrgyzstan": "吉尔吉斯斯坦",
                            "Lao PDR": "老挝",
                            "Latvia": "拉脱维亚",
                            "Lebanon": "黎巴嫩",
                            "Lesotho": "莱索托",
                            "Liberia": "利比里亚",
                            "Libya": "利比亚",
                            "Lithuania": "立陶宛",
                            "Luxembourg": "卢森堡",
                            "Macedonia": "北马其顿",
                            "Madagascar": "马达加斯加",
                            "Malawi": "马拉维",
                            "Malaysia": "马来西亚",
                            "Maldives": "马尔代夫",
                            "Mali": "马里",
                            "Malta": "马耳他",
                            "Mauritania": "毛利塔尼亚",
                            "Mauritius": "毛里求斯",
                            "Mexico": "墨西哥",
                            "Moldova": "摩尔多瓦",
                            "Monaco": "摩纳哥",
                            "Mongolia": "蒙古",
                            "Montenegro": "黑山",
                            "Morocco": "摩洛哥",
                            "Mozambique": "莫桑比克",
                            "Myanmar": "缅甸",
                            "Namibia": "纳米比亚",
                            "Nepal": "尼泊尔",
                            "Netherlands": "荷兰",
                            "New Caledonia": "新喀里多尼亚",
                            "New Zealand": "新西兰",
                            "Nicaragua": "尼加拉瓜",
                            "Niger": "尼日尔",
                            "Nigeria": "尼日利亚",
                            "Norway": "挪威",
                            "Oman": "阿曼",
                            "Pakistan": "巴基斯坦",
                            "Panama": "巴拿马",
                            "Papua New Guinea": "巴布亚新几内亚",
                            "Paraguay": "巴拉圭",
                            "Peru": "秘鲁",
                            "Philippines": "菲律宾",
                            "Poland": "波兰",
                            "Portugal": "葡萄牙",
                            "Puerto Rico": "波多黎各",
                            "Qatar": "卡塔尔",
                            "Reunion": "留尼旺",
                            "Romania": "罗马尼亚",
                            "Russia": "俄罗斯",
                            "Rwanda": "卢旺达",
                            "S. Geo. and S. Sandw. Is.": "南乔治亚和南桑威奇群岛",
                            "S. Sudan": "苏丹",
                            "San Marino": "圣马力诺",
                            "Saudi Arabia": "沙特阿拉伯",
                            "Senegal": "塞内加尔",
                            "Serbia": "塞尔维亚",
                            "Sierra Leone": "塞拉利昂",
                            "Singapore": "新加坡",
                            "Slovakia": "斯洛伐克",
                            "Slovenia": "斯洛文尼亚",
                            "Solomon Is.": "所罗门群岛",
                            "Somalia": "索马里",
                            "South Africa": "南非",
                            "Spain": "西班牙",
                            "Sri Lanka": "斯里兰卡",
                            "Sudan": "苏丹",
                            "Suriname": "苏里南",
                            "Swaziland": "斯威士兰",
                            "Sweden": "瑞典",
                            "Switzerland": "瑞士",
                            "Syria": "叙利亚",
                            "Tajikistan": "塔吉克斯坦",
                            "Tanzania": "坦桑尼亚",
                            "Thailand": "泰国",
                            "Togo": "多哥",
                            "Tonga": "汤加",
                            "Trinidad and Tobago": "特立尼达和多巴哥",
                            "Tunisia": "突尼斯",
                            "Turkey": "土耳其",
                            "Turkmenistan": "土库曼斯坦",
                            "U.S. Virgin Islands": "美属维尔京群岛",
                            "Uganda": "乌干达",
                            "Ukraine": "乌克兰",
                            "United Arab Emirates": "阿联酋",
                            "United Kingdom": "英国",
                            "United States": "美国",
                            "Uruguay": "乌拉圭",
                            "Uzbekistan": "乌兹别克斯坦",
                            "Vanuatu": "瓦努阿图",
                            "Vatican City": "梵蒂冈城",
                            "Venezuela": "委内瑞拉",
                            "Vietnam": "越南",
                            "W. Sahara": "西撒哈拉",
                            "Yemen": "也门",
                            "Yugoslavia": "南斯拉夫",
                            "Zaire": "扎伊尔",
                            "Zambia": "赞比亚",
                            "Zimbabwe": "津巴布韦"
}
}
    },
   created(){
        this.chinaConfigure(this.content);

     
  },
  methods:{
    chinaConfigure(data) {
      axios.get("http://localhost:8081/data").then((response)=>{
            var a=JSON.parse(JSON.stringify(response))
            console.log(a);
            var lists=a.data.map(item=>{
              return { name:item.location,value:item.nowdia}
            }
            )

         this.myChart = this.$echarts.init(document.getElementById("charts"));       
         window.onresize = this.myChart.resize;
         let option={
   
          tooltip: {
            trigger: 'item', 
	          formatter: '现有确诊<br/>{b0}:{c0}',
          },
          visualMap: {
            type: 'piecewise',
                            orient: 'horizontal',
                            left: 'center',
                            top: 'bottom',
                            splitList: [
                                {start: 100000,color:'#380909',label:'700000人以上'},{start: 400001,end:699999,color:'#4b0906',label:'7000-699999人'},
                                {start: 3001, end: 400000,color:'#a21508',label:'3000-7000人'},{start: 1001, end: 3000,color:'#be3128',label:'1000-3000人'},
                                {start: 100, end: 1000,color: '#e86832',label:'100-1000人'},{start: 1, end: 99,color:'#f6b791',label:'1-99人'},
                                {value:0,color:'#b5b5b5',label:'0人'}
                            ]
                        
                  },
        series: [{
        type: 'map',
        map: 'world',
        data: lists,
        nameMap: this.nameMap
    }]
        }
        this.myChart.setOption(option,true);
        this.myChart.on('click', params => {
        this.value=params.name
        this.myChart.setOption(option,true);
        })  
        });

      }
  }
}
</script>
