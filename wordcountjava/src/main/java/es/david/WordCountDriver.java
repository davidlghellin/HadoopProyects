package es.david;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCountDriver extends Configured implements Tool{

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

		if (args.length != 2) {
			System.out.println("Usage: WordCount <input dir> <output dir> \n");
			System.exit(-1);
		}

		Job job = Job.getInstance(new Configuration(), "Word Count");

		job.setJarByClass(getClass());

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setMapperClass(WordMapper.class);
		job.setReducerClass(SumReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);

		job.setOutputValueClass(IntWritable.class);
		boolean success = job.waitForCompletion(true);
		System.exit(success ? 0 : 1);

	}

	@Override
	public int run(String[] arg0) throws Exception {
ToolRunner.run(new WordCountDriver(),arg0);
		
		return 0;
	}

}
