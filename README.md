# VideoKeeper
Uses the [vget](https://github.com/axet/vget) library to download Youtube videos for Android.

### Todo:
1. Persist a lookup table so as to not download duplicate copies.<br>
2. Option to specify video quality.<br>
3. Use only the parser from vget and use Android DownloadManager for actual download.<br>
4. Implement eviction policy.

### Concerns:
* Is this even legal?
* This is flaky as it breaks once youtube's url encoding policy changes.
* Transcode Android acceptable flavors on the server?
