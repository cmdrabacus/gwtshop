function baseshop(){var P='',xb='" for "gwt:onLoadErrorFn"',vb='" for "gwt:onPropertyErrorFn"',ib='"><\/script>',Z='#',Fb='&',Zb='.cache.html',_='/',lb='//',Yb=':',pb='::',fc='<script defer="defer">baseshop.onInjectionDone(\'baseshop\')<\/script>',hb='<script id="',sb='=',$='?',ub='Bad handler "',ec='DOMContentLoaded',Xb="GWT module 'baseshop' may need to be (re)compiled",jb='SCRIPT',Ib='Unexpected exception in locale detection, using default: ',Hb='_',Gb='__gwt_Locale',gb='__gwt_marker_baseshop',kb='base',cb='baseUrl',Q='baseshop',eb='baseshop.nocache.js',ob='baseshop::',T='begin',S='bootstrap',bb='clear.cache.gif',rb='content',Db='default',Y='end',Rb='gecko',Sb='gecko1_8',U='gwt.codesvr=',V='gwt.hosted=',W='gwt.hybrid',$b='gwt/standard/standard.css',wb='gwt:onLoadErrorFn',tb='gwt:onPropertyErrorFn',qb='gwt:property',dc='head',Vb='hosted.html?baseshop',cc='href',Qb='ie6',Pb='ie8',Ob='ie9',yb='iframe',ab='img',zb="javascript:''",_b='link',Ub='loadExternalRefs',Cb='locale',Eb='locale=',mb='meta',Bb='moduleRequested',X='moduleStartup',Nb='msie',nb='name',Kb='opera',Ab='position:absolute;width:0;height:0;border:none',ac='rel',Mb='safari',db='script',Wb='selectingPermutation',R='startup',bc='stylesheet',fb='undefined',Tb='unknown',Jb='user.agent',Lb='webkit';var m=window,n=document,o=m.__gwtStatsEvent?function(a){return m.__gwtStatsEvent(a)}:null,p=m.__gwtStatsSessionId?m.__gwtStatsSessionId:null,q,r,s,t=P,u={},v=[],w=[],x=[],y=0,z,A;o&&o({moduleName:Q,sessionId:p,subSystem:R,evtGroup:S,millis:(new Date).getTime(),type:T});if(!m.__gwt_stylesLoaded){m.__gwt_stylesLoaded={}}if(!m.__gwt_scriptsLoaded){m.__gwt_scriptsLoaded={}}function B(){var b=false;try{var c=m.location.search;return (c.indexOf(U)!=-1||(c.indexOf(V)!=-1||m.external&&m.external.gwtOnLoad))&&c.indexOf(W)==-1}catch(a){}B=function(){return b};return b}
function C(){if(q&&r){var b=n.getElementById(Q);var c=b.contentWindow;if(B()){c.__gwt_getProperty=function(a){return H(a)}}baseshop=null;c.gwtOnLoad(z,Q,t,y);o&&o({moduleName:Q,sessionId:p,subSystem:R,evtGroup:X,millis:(new Date).getTime(),type:Y})}}
function D(){function e(a){var b=a.lastIndexOf(Z);if(b==-1){b=a.length}var c=a.indexOf($);if(c==-1){c=a.length}var d=a.lastIndexOf(_,Math.min(c,b));return d>=0?a.substring(0,d+1):P}
function f(a){if(a.match(/^\w+:\/\//)){}else{var b=n.createElement(ab);b.src=a+bb;a=e(b.src)}return a}
function g(){var a=G(cb);if(a!=null){return a}return P}
function h(){var a=n.getElementsByTagName(db);for(var b=0;b<a.length;++b){if(a[b].src.indexOf(eb)!=-1){return e(a[b].src)}}return P}
function i(){var a;if(typeof isBodyLoaded==fb||!isBodyLoaded()){var b=gb;var c;n.write(hb+b+ib);c=n.getElementById(b);a=c&&c.previousSibling;while(a&&a.tagName!=jb){a=a.previousSibling}if(c){c.parentNode.removeChild(c)}if(a&&a.src){return e(a.src)}}return P}
function j(){var a=n.getElementsByTagName(kb);if(a.length>0){return a[a.length-1].href}return P}
function k(){var a=n.location;return a.href==a.protocol+lb+a.host+a.pathname+a.search+a.hash}
var l=g();if(l==P){l=h()}if(l==P){l=i()}if(l==P){l=j()}if(l==P&&k()){l=e(n.location.href)}l=f(l);t=l;return l}
function E(){var b=document.getElementsByTagName(mb);for(var c=0,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(nb),g;if(f){f=f.replace(ob,P);if(f.indexOf(pb)>=0){continue}if(f==qb){g=e.getAttribute(rb);if(g){var h,i=g.indexOf(sb);if(i>=0){f=g.substring(0,i);h=g.substring(i+1)}else{f=g;h=P}u[f]=h}}else if(f==tb){g=e.getAttribute(rb);if(g){try{A=eval(g)}catch(a){alert(ub+g+vb)}}}else if(f==wb){g=e.getAttribute(rb);if(g){try{z=eval(g)}catch(a){alert(ub+g+xb)}}}}}}
function F(a,b){return b in v[a]}
function G(a){var b=u[a];return b==null?null:b}
function H(a){var b=w[a](),c=v[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(A){A(a,d,b)}throw null}
var I;function J(){if(!I){I=true;var a=n.createElement(yb);a.src=zb;a.id=Q;a.style.cssText=Ab;a.tabIndex=-1;n.body.appendChild(a);o&&o({moduleName:Q,sessionId:p,subSystem:R,evtGroup:X,millis:(new Date).getTime(),type:Bb});a.contentWindow.location.replace(t+L)}}
w[Cb]=function(){var b=null;var c=Db;try{if(!b){var d=location.search;var e=d.indexOf(Eb);if(e>=0){var f=d.substring(e+7);var g=d.indexOf(Fb,e);if(g<0){g=d.length}b=d.substring(e+7,g)}}if(!b){b=G(Cb)}if(!b){b=m[Gb]}if(b){c=b}while(b&&!F(Cb,b)){var h=b.lastIndexOf(Hb);if(h<0){b=null;break}b=b.substring(0,h)}}catch(a){alert(Ib+a)}m[Gb]=c;return b||Db};v[Cb]={de:0,'default':1};w[Jb]=function(){var b=navigator.userAgent.toLowerCase();var c=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(function(){return b.indexOf(Kb)!=-1}())return Kb;if(function(){return b.indexOf(Lb)!=-1}())return Mb;if(function(){return b.indexOf(Nb)!=-1&&n.documentMode>=9}())return Ob;if(function(){return b.indexOf(Nb)!=-1&&n.documentMode>=8}())return Pb;if(function(){var a=/msie ([0-9]+)\.([0-9]+)/.exec(b);if(a&&a.length==3)return c(a)>=6000}())return Qb;if(function(){return b.indexOf(Rb)!=-1}())return Sb;return Tb};v[Jb]={gecko1_8:0,ie6:1,ie8:2,ie9:3,opera:4,safari:5};baseshop.onScriptLoad=function(){if(I){r=true;C()}};baseshop.onInjectionDone=function(){q=true;o&&o({moduleName:Q,sessionId:p,subSystem:R,evtGroup:Ub,millis:(new Date).getTime(),type:Y});C()};E();D();var K;var L;if(B()){if(m.external&&(m.external.initModule&&m.external.initModule(Q))){m.location.reload();return}L=Vb;K=P}o&&o({moduleName:Q,sessionId:p,subSystem:R,evtGroup:S,millis:(new Date).getTime(),type:Wb});if(!B()){try{alert(Xb);return;var M=K.indexOf(Yb);if(M!=-1){y=Number(K.substring(M+1));K=K.substring(0,M)}L=K+Zb}catch(a){return}}var N;function O(){if(!s){s=true;if(!__gwt_stylesLoaded[$b]){var a=n.createElement(_b);__gwt_stylesLoaded[$b]=a;a.setAttribute(ac,bc);a.setAttribute(cc,t+$b);n.getElementsByTagName(dc)[0].appendChild(a)}C();if(n.removeEventListener){n.removeEventListener(ec,O,false)}if(N){clearInterval(N)}}}
if(n.addEventListener){n.addEventListener(ec,function(){J();O()},false)}var N=setInterval(function(){if(/loaded|complete/.test(n.readyState)){J();O()}},50);o&&o({moduleName:Q,sessionId:p,subSystem:R,evtGroup:S,millis:(new Date).getTime(),type:Y});o&&o({moduleName:Q,sessionId:p,subSystem:R,evtGroup:Ub,millis:(new Date).getTime(),type:T});n.write(fc)}
baseshop();