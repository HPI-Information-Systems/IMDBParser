# IMDBParser
Java-Tool to extract all historical data from the IMDB dumps (which are semi-structured text files) to change records in the following format:

<t,e,p,v> (meaning at point of time t entity e changed in property p to a new value v)

### The Data Source
Before IMDB started publishing their data as [tsv-files](https://datasets.imdbws.com/), there were weekly updates provided as semi-structured text files. This parser extracts information from this original data. The data can be obtained [here](ftp://ftp.fu-berlin.de/pub/misc/movies/database/
frozendata/). It contains the original version of the database of an unclear timestamp as well as diff-files to reconstruct the history. Unfortunately, some Diff-files are missing which is why only roughly three and a half years of data can be reconstructed.

### Usage

TODO


### Architecture

TODO
