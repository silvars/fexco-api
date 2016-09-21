package ie.com.fexco.eircode.api.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.inject.Singleton;

import org.springframework.stereotype.Component;

@Singleton
@Component
public class SyncLink
{
	private ReentrantLock lock = new ReentrantLock();

	public Lock getLock()
	{
		return lock;
	}
}