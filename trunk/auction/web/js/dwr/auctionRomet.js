
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (auctionRomet == null) var auctionRomet = {};
auctionRomet._path = '/auction/dwr';
auctionRomet.auction = function(p0, p1, p2, p3, callback) {
  dwr.engine._execute(auctionRomet._path, 'auctionRomet', 'auction', p0, p1, p2, p3, callback);
}
auctionRomet.setAuctionService = function(p0, callback) {
  dwr.engine._execute(auctionRomet._path, 'auctionRomet', 'setAuctionService', p0, callback);
}
