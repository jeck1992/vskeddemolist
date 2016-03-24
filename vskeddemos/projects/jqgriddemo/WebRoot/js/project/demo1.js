﻿$(function () {
  var basePath=document.getElementsByTagName('base')[0].href;
  var t1=$('<table></table>');
  t1.attr('id','myt1');
  $(document.body).append(t1);
  
  var p1=$('<div></div>');
  p1.attr('id','myp1');
  $(document.body).append(p1);
  
  $("#myt1").jqGrid({
      url: basePath+'demoproc/demo1proc.jsp',
      mtype: "GET",
      datatype: "json",
      page: 1,
      colNames: ['Order ID', 'Customer ID', 'Order Date', 'Freight', 'Ship Name'],
      colModel: [
          { name: 'OrderID', key: true, sortable: false },
          { name: 'CustomerID', sortable: false },
          { name: 'OrderDate', sortable: false },
          { name: 'Freight', sortable: false },
          { name: 'ShipName', sortable: false }
      ],
      //width: 750,
      height: 'auto',
      //autowidth:true,
      shrinkToFit:false,
      autoScroll: false,
      rowNum: 10,
      rowList : [5,10,15,20,25,30],
      rownumbers: true,
      pager: "#myp1"
  });
  
});