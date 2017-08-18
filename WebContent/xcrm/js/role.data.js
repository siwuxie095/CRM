/*!
 * Distpicker v1.0.4
 * https://github.com/fengyuanchen/distpicker
 *
 * Copyright (c) 2014-2016 Fengyuan Chen
 * Released under the MIT license
 *
 * Date: 2016-06-01T15:05:52.606Z
 */

(function (factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as anonymous module.
    define('ChineseDistricts', [], factory);
  } else {
    // Browser globals.
    factory();
  }
})(function () {

  var ChineseDistricts = {
    86: {
      1: '客户经理',
      2: '销售人员',
    },
    1: {
      1: 'plus'
    },
    2: {
      1: 'comm'
    }
  };

  if (typeof window !== 'undefined') {
    window.ChineseDistricts = ChineseDistricts;
  }

  return ChineseDistricts;

});
