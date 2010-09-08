
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (buyRomet == null) var buyRomet = {};
buyRomet._path = '/auction/dwr';
buyRomet.buyTradm = function(p0, callback) {
  dwr.engine._execute(buyRomet._path, 'buyRomet', 'buyTradm', p0, callback);
}
buyRomet.buyTrad = function(p0, callback) {
  dwr.engine._execute(buyRomet._path, 'buyRomet', 'buyTrad', p0, callback);
}
buyRomet.setOrderService = function(p0, callback) {
  dwr.engine._execute(buyRomet._path, 'buyRomet', 'setOrderService', p0, callback);
}
