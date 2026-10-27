Pod::Spec.new do |s|
  s.name             = 'APIVerveRelativeTimeFormatter'
  s.version          = '1.2.3'
  s.summary          = 'Relative Time Formatter converts Unix timestamps and ISO dates into readable relative time phrases.'
  s.description      = <<-'DESC'
Relative Time Formatter converts Unix timestamps and ISO dates into readable relative time phrases. Choose between short, long, or abbreviated styles to get humanized past or future strings, millisecond differences, and unit breakdowns from seconds to years.

This iOS/macOS SDK provides a convenient way to access the Relative Time Formatter from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/relativetimeformatter?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/relativetimeformatter-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveRelativeTimeFormatter/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
