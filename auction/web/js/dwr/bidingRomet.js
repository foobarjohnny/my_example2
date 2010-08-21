
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (bidingRomet == null) var bidingRomet = {};
bidingRomet._path = '/auction/dwr';
bidingRomet.find = function(p0, p1, p2, callback) {
  dwr.engine._execute(bidingRomet._path, 'bidingRomet', 'find', p0, p1, p2, callback);
}
bidingRomet.finish = function(p0, p1, p2, callback) {
  dwr.engine._execute(bidingRomet._path, 'bidingRomet', 'finish', p0, p1, p2, callback);
}
bidingRomet.setBidingService = function(p0, callback) {
  dwr.engine._execute(bidingRomet._path, 'bidingRomet', 'setBidingService', p0, callback);
}
