--
--	Script to create and load the tables for the sample indycar winner database.
--
--	$Id:	CLIndyWinners.sql, v 1.0.0.0 2001/11/12 R. Dyer
--
--	Drop tables

CREATE DATABASE IF NOT EXISTS IndyWinners;

USE IndyWinners;

DROP TABLE INDYWINNERS;

-- TABLE: indywinners
CREATE TABLE INDYWINNERS (
		year integer,
		driver VARCHAR(50),
		avgspeed DOUBLE(6,3),
	CONSTRAINT IndyWinnerPK primary key (year));
--


INSERT INTO IndyWinners VALUES(2019,"Simon Pagenaud",175.794);
INSERT INTO IndyWinners VALUES(2018,"Will Poweri",166.935);
INSERT INTO IndyWinners VALUES(2017,"Takuma Sato",155.395 ;
INSERT INTO IndyWinners VALUES(2016,"Alexander Rossi",166.634);
INSERT INTO IndyWinners VALUES(2015,"Juan Pablo Montoya",161.341);
INSERT INTO IndyWinners VALUES(2014,"Ryan Hunter-Reay",186.563);
INSERT INTO IndyWinners VALUES(2013,"Tony Kanaan",187.433);
INSERT INTO IndyWinners VALUES(2012,"Dario Frachitti",167.734);
INSERT INTO IndyWinners VALUES(2011,"Dan Wheldon",170.265);
INSERT INTO IndyWinners VALUES(2010,"Dario Frachitti",161.623);
INSERT INTO IndyWinners VALUES(2009,"Helio Castroneves",150.318);
INSERT INTO IndyWinners VALUES(2008,"Scott Dixon",143.567);
INSERT INTO IndyWinners VALUES(2007,"Dario Frachitti",151.774);
INSERT INTO IndyWinners VALUES(2006,"Sam Hornish Jr.",157.085);
INSERT INTO IndyWinners VALUES(2005,"Dan Wheldon",157.603);
INSERT INTO IndyWinners VALUES(2004,"Buddy Rice",138.518);
INSERT INTO IndyWinners VALUES(2003,"Gil de Ferran",156.291);
INSERT INTO IndyWinners VALUES(2002,"Helio Castroneves",166.499);
INSERT INTO IndyWinners VALUES(2001,"Helio Castroneves",141.574);
INSERT INTO IndyWinners VALUES(2000,"Juan Pablo Montoya",167.607);
INSERT INTO IndyWinners VALUES(1999,"Kenny Brack",153.176);
INSERT INTO IndyWinners VALUES(1998,"Eddie Cheever, Jr.",145.155);
INSERT INTO IndyWinners VALUES(1997,"Arie Luyendyk",145.827);
INSERT INTO IndyWinners VALUES(1996,"Buddy Lazier",147.956);
INSERT INTO IndyWinners VALUES(1995,"Jacques Villenueve",153.616);
INSERT INTO IndyWinners VALUES(1994,"Al Unser Jr.",160.872);
INSERT INTO IndyWinners VALUES(1993,"Emerson Fittipaldi",157.207);
INSERT INTO IndyWinners VALUES(1992,"Al Unser Jr.",134.477);
INSERT INTO IndyWinners VALUES(1991,"Rick Mears",176.457);
INSERT INTO IndyWinners VALUES(1990,"Arie Luyendyk",185.981);
INSERT INTO IndyWinners VALUES(1989,"Emerson Fittipaldi",167.581);
INSERT INTO IndyWinners VALUES(1988,"Rick Mears",144.809);
INSERT INTO IndyWinners VALUES(1987,"Al Unser Sr.",162.175);
INSERT INTO IndyWinners VALUES(1986,"Bobby Rahal",170.722);
INSERT INTO IndyWinners VALUES(1985,"Danny Sullivan",152.982);
INSERT INTO IndyWinners VALUES(1984,"Rick Mears",163.612);
INSERT INTO IndyWinners VALUES(1983,"Tom Sneva",162.117);
INSERT INTO IndyWinners VALUES(1982,"Gordon Johncock",162.029);
INSERT INTO IndyWinners VALUES(1981,"Bobby Unser",139.084);
INSERT INTO IndyWinners VALUES(1980,"Jonny Rutherford",142.862);
INSERT INTO IndyWinners VALUES(1979,"Rick Mears",158.899);
INSERT INTO IndyWinners VALUES(1978,"Al Unser Sr.",161.363);
INSERT INTO IndyWinners VALUES(1977,"A.J. Foyt",161.331);
INSERT INTO IndyWinners VALUES(1976,"Jonny Rutherford",148.725);
INSERT INTO IndyWinners VALUES(1975,"Bobby Unser",149.213);
INSERT INTO IndyWinners VALUES(1974,"Jonny Rutherford",158.589);
INSERT INTO IndyWinners VALUES(1973,"Gordon Johncock",159.036);
INSERT INTO IndyWinners VALUES(1972,"Mark Donohue",162.962);
INSERT INTO IndyWinners VALUES(1971,"Al Unser Sr.",157.73);
INSERT INTO IndyWinners VALUES(1970,"Al Unser Sr.",155.749);
INSERT INTO IndyWinners VALUES(1969,"Mario Andretti",156.867);
INSERT INTO IndyWinners VALUES(1968,"Bobby Unser",152.882);
INSERT INTO IndyWinners VALUES(1967,"A.J. Foyt",151.207);
INSERT INTO IndyWinners VALUES(1966,"Graham Hill",144.317);
INSERT INTO IndyWinners VALUES(1965,"Jimmy Clark",150.686);
INSERT INTO IndyWinners VALUES(1964,"A.J. Foyt",147.350);
INSERT INTO IndyWinners VALUES(1963,"Parnelli Jones",143.137);
INSERT INTO IndyWinners VALUES(1962,"Roger Ward",140.293);
INSERT INTO IndyWinners VALUES(1961,"A.J. Foyt",139.130);
INSERT INTO IndyWinners VALUES(1960,"Jim Rathmann",138.767);
INSERT INTO IndyWinners VALUES(1959,"Roger Ward",135.857);
INSERT INTO IndyWinners VALUES(1958,"Jim Bryan",133.791);
INSERT INTO IndyWinners VALUES(1957,"Sam Hanks",135.601);
INSERT INTO IndyWinners VALUES(1956,"Pat Flaherty",128.490);
INSERT INTO IndyWinners VALUES(1955,"Bob Sweikert",128.213);
INSERT INTO IndyWinners VALUES(1954,"Bill Vukovich",130.840);
INSERT INTO IndyWinners VALUES(1953,"Bill Vukovich",128.740);
INSERT INTO IndyWinners VALUES(1952,"Troy Ruttman",128.922);
INSERT INTO IndyWinners VALUES(1951,"Lee Wallard",126.244);
INSERT INTO IndyWinners VALUES(1950,"Jonnie Parsons",124.002);
INSERT INTO IndyWinners VALUES(1949,"Bill Holland",121.327);
INSERT INTO IndyWinners VALUES(1948,"Mauri Rose",119.814);
INSERT INTO IndyWinners VALUES(1947,"Mauri Rose",116.338);
INSERT INTO IndyWinners VALUES(1946,"George Robson",114.820);
INSERT INTO IndyWinners VALUES(1945,"(no race)",0.00);
INSERT INTO IndyWinners VALUES(1944,"(no race)",0.00);
INSERT INTO IndyWinners VALUES(1943,"(no race)",0.00);
INSERT INTO IndyWinners VALUES(1942,"(no race)",0.00);
INSERT INTO IndyWinners VALUES(1941,"Floyd Davis-Mauri Rose",115.117);
INSERT INTO IndyWinners VALUES(1940,"Wilbur Shaw",114.277);
INSERT INTO IndyWinners VALUES(1939,"Wilbur Shaw",115.035);
INSERT INTO IndyWinners VALUES(1938,"Floyd Roberts",117.200);
INSERT INTO IndyWinners VALUES(1937,"Wilbur Shaw",113.580);
INSERT INTO IndyWinners VALUES(1936,"Louis Meyer",109.069);
INSERT INTO IndyWinners VALUES(1935,"Kelly Petillo",106.240);
INSERT INTO IndyWinners VALUES(1934,"William Cummings",104.863);
INSERT INTO IndyWinners VALUES(1933,"Louis Meyer",104.162);
INSERT INTO IndyWinners VALUES(1932,"Fred Frame",104.144);
INSERT INTO IndyWinners VALUES(1931,"Louis Schneider",96.629);
INSERT INTO IndyWinners VALUES(1930,"Billy Arnold",100.448);
INSERT INTO IndyWinners VALUES(1929,"Ray Keech",97.585);
INSERT INTO IndyWinners VALUES(1928,"Louis Meyer",99.482);
INSERT INTO IndyWinners VALUES(1927,"George Souders",97.545);
INSERT INTO IndyWinners VALUES(1926,"Frank Lockhart",95.904);
INSERT INTO IndyWinners VALUES(1925,"Peter DePaolo",101.127);
INSERT INTO IndyWinners VALUES(1924,"L.L Corum/Joe Boyer",98.234);
INSERT INTO IndyWinners VALUES(1923,"Tommy Milton",90.954);
INSERT INTO IndyWinners VALUES(1922,"Jimmy Murphy",94.484);
INSERT INTO IndyWinners VALUES(1921,"Tommy Milton",89.621);
INSERT INTO IndyWinners VALUES(1920,"Gaston Chevrolet",88.618);
INSERT INTO IndyWinners VALUES(1919,"Howard Wilcox",88.05);
INSERT INTO IndyWinners VALUES(1918,"(no race)",0.00);
INSERT INTO IndyWinners VALUES(1917,"(no race)",0.00);
INSERT INTO IndyWinners VALUES(1916,"Dario Resta",84.001);
INSERT INTO IndyWinners VALUES(1915,"Ralph DePalma",89.840);
INSERT INTO IndyWinners VALUES(1914,"Rene Thomas",82.474);
INSERT INTO IndyWinners VALUES(1913,"Jules Goux",75.933);
INSERT INTO IndyWinners VALUES(1912,"Joe Dawson",78.719);
INSERT INTO IndyWinners VALUES(1911,"Ray Harroun",74.602);

commit;