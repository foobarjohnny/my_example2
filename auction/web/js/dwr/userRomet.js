
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (userRomet == null) var userRomet = {};
userRomet._path = '/auction/dwr';
userRomet.setUserService = function(p0, callback) {
  dwr.engine._execute(userRomet._path, 'userRomet', 'setUserService', p0, callback);
}
userRomet.changePass = function(p0, p1, p2, callback) {
  dwr.engine._execute(userRomet._path, 'userRomet', 'changePass', p0, p1, p2, callback);
}
