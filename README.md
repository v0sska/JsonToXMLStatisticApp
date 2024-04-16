Json entity in which data from JsonParser is written and has fields such as: label, genre, group, foundedYear
Statistic entity for recording in an xml file. In item, data from a json file is recorded. In Item, there are fields value (value that comes from JsonParser) and count (number of values)
Example of input files:
{
    "label": "Universal Music Group",
    "group": "Queen",
    "genre": "rock",
    "founded_year": 1970
  },
  {
    "label": "EMI",
    "group": "Pink Floyd",
    "genre": "progressive rock",
    "founded_year": 1965
  }
  Example of output files:
  <statistic>
    <item>
        <value>rock</value>
        <count>6</count>
    </item>
    <item>
        <value>soul</value>
        <count>4</count>
    </item>
    ...
    </statistic>
    
Results of work in multithreading:
  2-1062ms
  4-1123ms
  6-974ms
  8-858ms
    
