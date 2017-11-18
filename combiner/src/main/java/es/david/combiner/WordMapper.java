package es.david.combiner;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable pKey, Text pValue, Context pContext) throws IOException, InterruptedException {
		
		String line = pValue.toString();
		
		for (String word : line.split("\\W+")) {
			if (word.length() > 0) {
				pContext.write(new Text(word), new IntWritable(1));
			}
		}
	}

}
