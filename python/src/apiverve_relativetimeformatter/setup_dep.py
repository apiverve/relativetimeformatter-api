from setuptools import setup, find_packages

setup(
    name='apiverve_relativetimeformatter',
    version='1.2.3',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Relative Time Formatter converts Unix timestamps and ISO dates into readable relative time phrases. Choose between short, long, or abbreviated styles to get humanized past or future strings, millisecond differences, and unit breakdowns from seconds to years.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/relativetimeformatter?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
