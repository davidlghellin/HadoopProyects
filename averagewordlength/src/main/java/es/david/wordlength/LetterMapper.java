package es.david.wordlength;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LetterMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable pKey, Text pValue, Context pContext) throws IOException, InterruptedException {

		String line = pValue.toString();

		for (String word : line.split(" ")) {
			if (word.length() > 0) {
				pContext.write(new Text(word.substring(0, 1)), new IntWritable(word.length()));
			}
		}
	}

}
