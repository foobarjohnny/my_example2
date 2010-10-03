
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (loginRomet == null) var loginRomet = {};
loginRomet._path = '/auction/dwr';
loginRomet.login = function(p0, p1, callback) {
  dwr.engine._execute(loginRomet._path, 'loginRomet', 'login', p0, p1, callback);
}
loginRomet.loginOut = function(callback) {
  dwr.engine._execute(loginRomet._path, 'loginRomet', 'loginOut', callback);
}
loginRomet.checkedEmail = function(p0, callback) {
  dwr.engine._execute(loginRomet._path, 'loginRomet', 'checkedEmail', p0, callback);
}
loginRomet.checkedUser = function(p0, callback) {
  dwr.engine._execute(loginRomet._path, 'loginRomet', 'checkedUser', p0, callback);
}
loginRomet.setUserService = function(p0, callback) {
  dwr.engine._execute(loginRomet._path, 'loginRomet', 'setUserService', p0, callback);
}
