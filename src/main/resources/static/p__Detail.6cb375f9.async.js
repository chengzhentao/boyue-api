"use strict";(self.webpackChunkant_design_pro=self.webpackChunkant_design_pro||[]).push([[744],{1210:function(j,p,t){t.r(p);var h=t(5574),n=t.n(h),f=t(43285),i=t(90930),E=t(97821),_=t(67294),s=t(85893),b=function(){var v=(0,_.useState)(1),l=n()(v,2),D=l[0],d=l[1],g=(0,_.useState)(10),o=n()(g,2),P=o[0],c=o[1],r=[{title:"\u7EF4\u4FEE\u7F16\u53F7",dataIndex:"orderNo",search:!0},{title:"\u7EF4\u4FEE\u9879\u76EE",dataIndex:"name",search:!0},{title:"\u6570\u91CF",dataIndex:"number",search:!1},{title:"\u5355\u4F4D",dataIndex:"unit",search:!1},{title:"\u4EF7\u683C",dataIndex:"price",search:!1},{title:"\u91D1\u989D",dataIndex:"total",search:!1},{title:"\u8BA2\u5355\u65F6\u95F4",dataIndex:"total",search:!1},{title:"\u5907\u6CE8",dataIndex:"remark",search:!1}],a=function(e){var M,O;return d((M=e==null?void 0:e.current)!==null&&M!==void 0?M:1),c((O=e==null?void 0:e.pageSize)!==null&&O!==void 0?O:10),(0,f.ll)(e).then(function(y){return{data:y.data.records,success:!0,total:y.data.total}})};return(0,s.jsx)(i._z,{children:(0,s.jsx)(E.Z,{request:function(e){return a(e)},pagination:{pageSize:P,current:D},columns:r,rowKey:function(e){return e.id}})})};p.default=b},43285:function(j,p,t){t.d(p,{$c:function(){return g},a1:function(){return D},lA:function(){return v},ll:function(){return P},pb:function(){return b}});var h=t(15009),n=t.n(h),f=t(97857),i=t.n(f),E=t(99289),_=t.n(E),s=t(88275);function b(r){return m.apply(this,arguments)}function m(){return m=_()(n()().mark(function r(a){return n()().wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,s.request)("/api/order/list",{method:"GET",params:i()({},a||{})}));case 1:case"end":return e.stop()}},r)})),m.apply(this,arguments)}function v(r){return l.apply(this,arguments)}function l(){return l=_()(n()().mark(function r(a){return n()().wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,s.request)("/api/order/detail",{method:"GET",params:i()({},a||{})}));case 1:case"end":return e.stop()}},r)})),l.apply(this,arguments)}function D(r){return d.apply(this,arguments)}function d(){return d=_()(n()().mark(function r(a){return n()().wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,s.request)("/api/order/save",{method:"post",data:a}));case 1:case"end":return e.stop()}},r)})),d.apply(this,arguments)}function g(r){return o.apply(this,arguments)}function o(){return o=_()(n()().mark(function r(a){return n()().wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,s.request)("/api/order/delete",{method:"post",data:a}));case 1:case"end":return e.stop()}},r)})),o.apply(this,arguments)}function P(r){return c.apply(this,arguments)}function c(){return c=_()(n()().mark(function r(a){return n()().wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,s.request)("/api/detail/list",{method:"GET",params:i()({},a||{})}));case 1:case"end":return e.stop()}},r)})),c.apply(this,arguments)}}}]);
