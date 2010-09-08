
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (publisRomet == null) var publisRomet = {};
publisRomet._path = '/auction/dwr';
publisRomet.vote = function(p0, callback) {
  dwr.engine._execute(publisRomet._path, 'publisRomet', 'vote', p0, callback);
}
publisRomet.setPublisService = function(p0, callback) {
  dwr.engine._execute(publisRomet._path, 'publisRomet', 'setPublisService', p0, callback);
}
